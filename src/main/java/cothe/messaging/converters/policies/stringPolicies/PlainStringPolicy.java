package cothe.messaging.converters.policies.stringPolicies;

import cothe.messaging.model.DataElement;

/**
 * @author Jeongjin Kim
 * @since 2017-08-25
 */
public class PlainStringPolicy implements StringPolicy {
    @Override
    public String convert(Object data, DataElement dataElement) {
        if(data == null){
            return "";
        }

        return data.toString();

    }
}
