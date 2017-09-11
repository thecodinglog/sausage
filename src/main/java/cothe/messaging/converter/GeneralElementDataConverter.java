package cothe.messaging.converter;

import cothe.messaging.model.ElementType;
import cothe.messaging.converter.policies.ConvertingPolicy;
import cothe.messaging.model.DataElement;
import lombok.NonNull;
import lombok.Setter;

import java.nio.charset.Charset;
import java.util.Locale;
import java.util.Map;

/**
 * @author Jeongjin Kim
 * @since 2017-08-23
 */
public class GeneralElementDataConverter implements ElementDataConverter {
    final private Charset charset;
    final private Locale locale;
    final private CharSequence delimiter;

    public GeneralElementDataConverter(Charset charset, Locale locale, CharSequence delimiter) {
        this.charset = charset;
        this.locale = locale;
        this.delimiter = delimiter;
    }

    @Setter
    private Map<ElementType, ConvertingPolicy> policies;

    @Override
    public String convert(@NonNull DataElement element, Object data) {
        ConvertingPolicy convertingPolicy = policies.get(element.getElementType());
        if (convertingPolicy == null) {
            if (data == null) {
                return null;
            }
            return data.toString();
        } else {
            return convertingPolicy.convert(data, element, charset, locale);
        }
    }

    @Override
    public <T> T convertBack(DataElement element, String data) {
        ConvertingPolicy convertingPolicy = policies.get(element.getElementType());
        if(convertingPolicy == null){
            if(data == null){
                return null;
            }
            return (T) data.toString();
        }else{
            return convertingPolicy.convertBack(data, element, charset, locale);
        }

    }

    @Override
    public CharSequence getDelimiter() {
        return delimiter;
    }

    @Override
    public Locale getLocale() {
        return locale;
    }

    @Override
    public Charset getCharset() {
        return charset;
    }
}
