package cothe.messaging;

import cothe.messaging.model.StructureElement;

import java.util.Map;

/**
 * @author Jeongjin Kim
 * @since 2017-08-23
 */
public class MessageStructureLoaderImpl implements MessageStructureLoader {
    private Map<String, StructureElement> cache;

    @Override
    public StructureElement getMessageStructure(String messageStructureId) {

        return cache.get(messageStructureId);
    }
}
