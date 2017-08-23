package cothe.model;

import cothe.domain.ElementType;

public interface ElementFormatter {
    String format(ElementType elementType, Object data);
}
