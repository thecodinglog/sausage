package cothe.messaging.converters.policies.numberPolicies;

import cothe.messaging.model.DataElement;

/**
 * @author Jeongjin Kim
 * @since 2017-08-25
 */
public class PlainNumberPolicy implements NumberPolicy {
    @Override
    public String convert(Object data, DataElement dataElement) {
        return data.toString();
    }
}
