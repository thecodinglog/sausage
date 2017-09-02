package cothe.messaging.converters.policies.numberPolicies;

import cothe.messaging.model.Element;

/**
 * @author Jeongjin Kim
 * @since 2017-08-25
 */
public class PlainNumberPolicy implements NumberPolicy {
    @Override
    public String convert(Object data) {
        return convert(data, null);
    }

    @Override
    public String convert(Object data, Element element) {
        return data.toString();
    }
}
