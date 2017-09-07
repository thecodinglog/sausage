package cothe.messaging.converters.policies.booleanPolicies;

import cothe.messaging.model.DataElement;
import org.apache.commons.lang3.StringUtils;


/**
 * @author Jeongjin Kim
 * @since 2017-08-25
 */
public class FixedLengthRightPaddingYNBooleanPolicy extends YNBooleanPolicy {
    @Override
    public String convert(Object data, DataElement dataElement) {
        String convertedData = super.convert(data, dataElement);
        convertedData = convertedData.length() < dataElement.getLength() ? convertedData : convertedData.substring(0, dataElement.getLength());

        return StringUtils.rightPad(convertedData, dataElement.getLength());
    }
}
