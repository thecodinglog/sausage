package cothe.messaging.converters.policies;

import cothe.messaging.model.Element;

/**
 * @author Jeongjin Kim
 * @since 2017-08-24
 */
public interface ConvertingPolicy {
    String convert(Object data);
    String convert(Object data, Element element);
}
