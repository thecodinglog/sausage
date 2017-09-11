package cothe.messaging.converter.policies;

import cothe.messaging.model.DataElement;

import java.nio.charset.Charset;
import java.util.Locale;

/**
 * @author Jeongjin Kim
 * @since 2017-08-24
 */
public interface ConvertingPolicy {
    String convert(final Object data, final DataElement dataElement, final Charset charset, final Locale locale);

    default String convert(final Object data, final DataElement dataElement) {
        return convert(data, dataElement, null, null);
    }

    default <T> T convertBack(final String data, final DataElement dataElement, final Charset charset, final Locale locale) {
        throw new UnsupportedOperationException();
    }

    default <T> T convertBack(final String data, final DataElement dataElement) {
        return convertBack(data, dataElement, null, null);
    }
}
