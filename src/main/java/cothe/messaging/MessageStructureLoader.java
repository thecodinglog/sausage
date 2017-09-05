package cothe.messaging;

import cothe.messaging.model.StructureElement;

/**
 * @author Jeongjin Kim
 * @since 2017-08-23
 */
public interface MessageStructureLoader {
    StructureElement getMessageStructure(String messageStructureId);
}
