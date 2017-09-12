package cothe.messaging.parser;

import cothe.messaging.exceptions.DecodingException;
import lombok.NonNull;

import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.CharacterCodingException;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.CodingErrorAction;
import java.util.*;

/**
 * @author Jeongjin Kim
 * @since 2017. 9. 9.
 */
public class CompartmentalByteLengthString implements Compartmental<String> {

    final private String sourceString;
    final private Iterable<Integer> roomSizeList;
    final private CharSequence delimiter;

    private List<String> elements;

    public CompartmentalByteLengthString(@NonNull String sourceString, Iterable<Integer> roomSizeList, CharSequence delimiter, Charset charset) {
        this.sourceString = sourceString;
        this.roomSizeList = roomSizeList;
        this.delimiter = (delimiter == null) ? "" : delimiter;
        Charset charsetLocal = charset == null ? Charset.defaultCharset() : charset;

        if (roomSizeList == null && (delimiter.toString().equals(""))) {
            throw new IllegalArgumentException("parameter 'roomSizeList' can't be null when 'delimiter' is empty");
        }

        if (this.delimiter.length() > 0) {
            elements = Arrays.asList(sourceString.split(delimiter.toString()));

        } else {
            elements = new ArrayList<>();

            byte[] src = sourceString.getBytes(charsetLocal);

            int accIndex = 0;

            String convertedData;

            CharsetDecoder charsetDecoder = charset.newDecoder();
            charsetDecoder
                    .onMalformedInput(CodingErrorAction.REPORT)
                    .onUnmappableCharacter(CodingErrorAction.REPORT);

            for (Integer integer : this.roomSizeList) {

                try {
                    byte[] newByteStr = Arrays.copyOfRange(src, accIndex, accIndex + integer);

                    CharBuffer charBuffer = null;
                    try {
                        charBuffer = charsetDecoder.decode(ByteBuffer.wrap(newByteStr));
                    } catch (CharacterCodingException e) {
                        throw new DecodingException(e);
                    }

                    if (charBuffer == null) {
                        convertedData = null;
                    } else {
                        convertedData = charBuffer.toString();
                    }

                    elements.add(convertedData);
                    accIndex += integer;
                } catch (Exception e) {
                    List<Integer> list = new ArrayList<>();
                    for (Integer i : roomSizeList) {
                        list.add(i);
                    }

                    for (int i = 0; i < elements.size(); i++) {
                        System.out.println(elements.get(i) + ":" + list.get(i));
                    }

                    throw e;
                }
            }
        }


    }


    @Override
    public int getCompartmentSize() {
        return elements.size();
    }

    public int getByteLength(Charset charset) {
        return getByteLength(charset, true);
    }

    @Override
    public int getByteLength(Charset charset, boolean exceptDelimiter) {

        if (exceptDelimiter) {
            return (sourceString.replace(delimiter, "")).getBytes(charset).length;
        } else {
            return sourceString.getBytes(charset).length;

        }
    }

    @Override
    public String get(int index) {
        return elements.get(index);
    }

    @Override
    public Iterator<String> iterator() {
        return elements.iterator();
    }
}
