package cothe.messaging.converters.policies.numberPolicies;

import cothe.messaging.exceptions.NotEnoughLengthException;
import cothe.messaging.model.DataElement;
import org.apache.commons.lang3.StringUtils;

/**
 * @author Jeongjin Kim
 * @since 2017-09-07
 */
public class FixedLengthLeftPaddingNumberPolicy extends PlainNumberPolicy {
    @Override
    public String convert(Object data, DataElement dataElement) {
        String convertedData = super.convert(data, dataElement);
        if (convertedData.length() > dataElement.getLength()) {
            throw new NotEnoughLengthException("Original data length is " + convertedData.length() + ", but need " + dataElement.getLength());
        }

        return StringUtils.leftPad(convertedData, dataElement.getLength());
    }
}
