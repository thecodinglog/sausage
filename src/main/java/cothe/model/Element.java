package cothe.model;

import cothe.domain.ElementType;
import lombok.Data;

public @Data class Element {
    private String id;
    private String name;
    private ElementType type;
    private int length;
    private int precision;
    private String unit;

}
