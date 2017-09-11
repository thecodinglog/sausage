package cothe.messaging.model;

import lombok.Data;

public @Data
class DataElement implements Element {
    private String id;
    private String name;
    private ElementType elementType;
    private int length;
    private int precision;
    private String unit;

    public DataElement(String id, String name, ElementType elementType, int length, int precision, String unit) {
        this.id = id;
        this.name = name;
        this.elementType = elementType;
        this.length = length;
        this.precision = precision;
        this.unit = unit;
    }
}
