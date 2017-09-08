package cothe.messaging.converters.policies.currencyPolicies;

import cothe.messaging.model.DataElement;
import org.apache.commons.lang3.StringUtils;

/**
 * @author Jeongjin Kim
 * @since 2017-09-06
 */
public class FixedLengthLeftPaddingCurrencyPolicy extends DefaultCurrencyPolicy {

    @Override
    public String convert(Object data, DataElement dataElement) {
        String convertedData = super.convert(data, dataElement);
        convertedData = convertedData.length() < dataElement.getLength() ? convertedData : convertedData.substring(0, dataElement.getLength());

        return StringUtils.leftPad(convertedData, dataElement.getLength());
    }
}
