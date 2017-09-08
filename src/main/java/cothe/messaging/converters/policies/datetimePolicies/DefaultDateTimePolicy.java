package cothe.messaging.converters.policies.datetimePolicies;

import cothe.messaging.exceptions.UnsupportedFormatException;
import cothe.messaging.model.DataElement;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @author Jeongjin Kim
 * @since 2017-08-25
 */
public class DefaultDateTimePolicy implements DateTimePolicy {
    @Override
    public String convert(Object data, DataElement dataElement) {
        if (data == null) {
            return "";
        }

        int substringLength;

        if (dataElement.getLength() >= 4 && dataElement.getLength() < 6) {
            substringLength = 4;
        } else if (dataElement.getLength() >= 6 && dataElement.getLength() < 8) {
            substringLength = 6;
        } else if (dataElement.getLength() >= 8 && dataElement.getLength() < 10) {
            substringLength = 8;
        } else if (dataElement.getLength() >= 10 && dataElement.getLength() < 12) {
            substringLength = 10;
        } else if (dataElement.getLength() >= 12 && dataElement.getLength() < 14) {
            substringLength = 12;
        } else if (dataElement.getLength() >= 14 && dataElement.getLength() < 17) {
            substringLength = 14;
        } else if (dataElement.getLength() >= 17) {
            substringLength = 17;
        } else {
            substringLength = 0;
        }


        SimpleDateFormat toDateFormat = new SimpleDateFormat("yyyyMMddHHmmssSSS");

        List<String> formats = Arrays.asList(
                "yyyy-MM-dd HH:mm:ss:SSS",
                "yyyy-MM-dd HH:mm:ss,SSS",
                "yyyy-MM-dd HH:mm:ss",
                "yyyy-MM-dd HH:mm",
                "yyyy-MM-dd",
                "yyyyMMddHHmmssSSS",
                "yyyyMMddHHmmss",
                "yyyyMMddHHmm",
                "yyyyMMdd"
        );

        String returnDatetime = null;

        if (data instanceof Calendar) {
            returnDatetime = toDateFormat.format(((Calendar) data).getTime());
        } else if (data instanceof Date) {
            returnDatetime = toDateFormat.format(data);
        } else if (data instanceof String) {
            for (String format : formats) {
                try {
                    returnDatetime = toDateFormat.format((new SimpleDateFormat(format)).parse((String) data));
                    break;
                } catch (ParseException e) {
                }
            }

        }
        if (returnDatetime == null) {
            throw new UnsupportedFormatException("Fail to convert to DateTime of '" + data + "'");
        }


        return returnDatetime.substring(0, substringLength);
    }
}
