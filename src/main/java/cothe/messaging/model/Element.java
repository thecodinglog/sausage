package cothe.messaging.model;

import cothe.domain.ElementType;
import lombok.Data;

public @Data
class Element implements ElementMember {
    private String id;
    private String name;
    private ElementType type;
    private int length;
    private int precision;
    private String unit;
    private char filler;

    public Element(String id, String name, ElementType type, int length, int precision, String unit) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.length = length;
        this.precision = precision;
        this.unit = unit;
        this.filler = ' ';
    }

    public Element(String id, String name, ElementType type, int length, int precision, String unit, char filler) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.length = length;
        this.precision = precision;
        this.unit = unit;
        this.filler = filler;
    }
}
