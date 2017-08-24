package cothe.messaging.converters;

import cothe.domain.ElementType;

public interface ElementDataConverter {
    String convert(ElementType elementType, Object data);
}
