package cothe.messaging.converter.policies.stringPolicies;

import cothe.messaging.model.DataElement;

import java.nio.charset.Charset;
import java.util.Locale;

/**
 * @author Jeongjin Kim
 * @since 2017-08-25
 */
public class PlainStringPolicy implements StringPolicy {


    @Override
    public String convert(Object data, DataElement dataElement, Charset charset, Locale locale) {
        if (data == null) {
            return "";
        }

        return data.toString();
    }





}
