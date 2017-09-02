package cothe.messaging.converters.policies.stringPolicies;

import cothe.messaging.model.Element;

/**
 * @author Jeongjin Kim
 * @since 2017-08-25
 */
public class PlainStringPolicy implements StringPolicy {
    @Override
    public String convert(Object data) {
        return convert(data, null);
    }

    @Override
    public String convert(Object data, Element element) {
        return data.toString();
    }
}
