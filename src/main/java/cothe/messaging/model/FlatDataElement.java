package cothe.messaging.model;

import lombok.Getter;
import lombok.Setter;

/**
 * @author Jeongjin Kim
 * @since 2017. 9. 9.
 */
public class FlatDataElement {
    @Getter
    private String newId;

    @Getter
    private DataElement dataElement;


    public FlatDataElement(String newId, DataElement dataElement) {
        this.newId = newId;
        this.dataElement = dataElement;
    }
}
