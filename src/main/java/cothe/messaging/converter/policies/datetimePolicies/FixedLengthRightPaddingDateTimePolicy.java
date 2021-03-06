package cothe.messaging.converter.policies.datetimePolicies;

import cothe.messaging.model.DataElement;
import org.apache.commons.lang3.StringUtils;

import java.nio.charset.Charset;
import java.util.Locale;

/**
 * @author Jeongjin Kim
 * @since 2017-09-06
 */
public class FixedLengthRightPaddingDateTimePolicy extends DefaultDateTimePolicy {
    @Override
    public String convert(Object data, DataElement dataElement, Charset charset, Locale locale) {
        String convertedData = super.convert(data, dataElement, charset, locale);
        convertedData = convertedData.length() < dataElement.getLength() ? convertedData : convertedData.substring(0, dataElement.getLength());

        return StringUtils.rightPad(convertedData, dataElement.getLength());
    }
}
