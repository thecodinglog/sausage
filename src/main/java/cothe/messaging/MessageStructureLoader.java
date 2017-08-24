package cothe.messaging;

import cothe.messaging.model.MessageStructure;

/**
 * @author Jeongjin Kim
 * @since 2017-08-23
 */
public interface MessageStructureLoader {
    MessageStructure getMessageStructure(String messageStructureId);
}
