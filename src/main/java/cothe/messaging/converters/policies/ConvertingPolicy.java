package cothe.messaging.converters.policies;

import cothe.messaging.model.DataElement;

/**
 * @author Jeongjin Kim
 * @since 2017-08-24
 */
public interface ConvertingPolicy {
    String convert(Object data, DataElement dataElement);
}
