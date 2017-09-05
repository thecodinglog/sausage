package cothe.messaging.converters.policies.datetimePolicies;

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
    public String convert(Object data) {
        return convert(data, null);
    }

    @Override
    public String convert(Object data, DataElement dataElement) {
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

        if (data instanceof Calendar) {
            return toDateFormat.format(((Calendar) data).getTime());
        } else if (data instanceof Date) {
            return toDateFormat.format(data);
        } else if (data instanceof String) {
            for (String format : formats) {
                try {
                    return toDateFormat.format((new SimpleDateFormat(format)).parse((String) data));
                } catch (ParseException e) {
                }
            }
            throw new UnsupportedOperationException("Fail to convert to DateTime of '" + data + "'");
        }

        return data.toString();
    }
}
