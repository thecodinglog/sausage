package cothe.messaging;

import cothe.messaging.model.MessageStructure;

import java.util.Map;

/**
 * @author Jeongjin Kim
 * @since 2017-08-23
 */
public class MessageStructureLoaderImpl implements MessageStructureLoader {
    private Map<String, MessageStructure> cache;

    @Override
    public MessageStructure getMessageStructure(String messageStructureId) {

        return cache.get(messageStructureId);
    }
}
