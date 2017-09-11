package cothe.messaging.converter.policies.numberPolicies;

import cothe.messaging.exceptions.NotEnoughLengthException;
import cothe.messaging.model.DataElement;
import org.apache.commons.lang3.StringUtils;

import java.nio.charset.Charset;
import java.util.Locale;

/**
 * @author Jeongjin Kim
 * @since 2017-09-07
 */
public class FixedLengthLeftPaddingNumberPolicy extends PlainNumberPolicy {
    @Override
    public String convert(Object data, DataElement dataElement, Charset charset, Locale locale) {
        String convertedData = super.convert(data, dataElement, charset, locale);
        if (convertedData.length() > dataElement.getLength()) {
            throw new NotEnoughLengthException("Original data length is " + convertedData.length() + ", but need " + dataElement.getLength());
        }

        return StringUtils.leftPad(convertedData, dataElement.getLength());
    }
}
