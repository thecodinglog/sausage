package cothe.messaging.converters.policies.stringPolicies;

import cothe.messaging.model.DataElement;
import org.apache.commons.lang3.StringUtils;

/**
 * @author Jeongjin Kim
 * @since 2017-09-07
 */
public class EUCKrFixedByteLengthRightPaddingStringPolicy extends PlainStringPolicy {
    @Override
    public String convert(Object data, DataElement dataElement) {
        String convertedData = super.convert(data, dataElement);
        convertedData = convertedData.length() < dataElement.getLength() ? convertedData : convertedData.substring(0, dataElement.getLength());

        return StringUtils.leftPad(convertedData, dataElement.getLength());
    }
}
