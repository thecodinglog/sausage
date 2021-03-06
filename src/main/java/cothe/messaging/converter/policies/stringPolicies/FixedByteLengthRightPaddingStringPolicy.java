package cothe.messaging.converter.policies.stringPolicies;

import cothe.messaging.exceptions.DecodingException;
import cothe.messaging.model.DataElement;

import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.CharacterCodingException;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.CodingErrorAction;
import java.util.Arrays;
import java.util.Locale;

/**
 * @author Jeongjin Kim
 * @since 2017-09-07
 */
public class FixedByteLengthRightPaddingStringPolicy extends PlainStringPolicy {
    @Override
    public String convert(Object data, DataElement dataElement, Charset charset, Locale locale) {
        if (charset == null) {
            charset = Charset.defaultCharset();
        }

        String convertedData = super.convert(data, dataElement, charset, locale);

        byte[] orgByteStr = convertedData.getBytes(charset);

        if (orgByteStr.length > dataElement.getLength()) {
            byte[] newByteStr;

            newByteStr = Arrays.copyOfRange(orgByteStr, 0, dataElement.getLength());

            CharsetDecoder charsetDecoder = charset.newDecoder();
            charsetDecoder.replaceWith(" ")
                    .onMalformedInput(CodingErrorAction.REPLACE)
                    .onUnmappableCharacter(CodingErrorAction.REPLACE);

            CharBuffer charBuffer;
            try {
                charBuffer = charsetDecoder.decode(ByteBuffer.wrap(newByteStr));
            } catch (CharacterCodingException e) {
                throw new DecodingException(e);
            }

            convertedData = charBuffer.toString();

            //The length of the bytes may vary depending on the system and encoding.
            byte[] recheckByte = convertedData.getBytes(charset);

            if (recheckByte.length != dataElement.getLength()) {
                convertedData += makeWhiteSpace(dataElement.getLength() - recheckByte.length);
            }


        } else {
            convertedData += makeWhiteSpace(dataElement.getLength() - orgByteStr.length);


        }

        return convertedData;
    }


    private String makeWhiteSpace(int length) {
        StringBuilder sb = new StringBuilder(length);
        for (int i = 0; i < length; i++) {
            sb.append(" ");
        }
        return sb.toString();
    }
}
