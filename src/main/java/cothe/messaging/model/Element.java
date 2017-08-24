package cothe.messaging.model;

import cothe.domain.ElementType;
import lombok.Data;

public @Data class Element {
    private String id;
    private String name;
    private ElementType type;
    private int length;
    private int precision;
    private String unit;

    public Element(String id, String name, ElementType type, int length, int precision, String unit) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.length = length;
        this.precision = precision;
        this.unit = unit;
    }
}
