package cothe.messaging.converters;

import cothe.messaging.model.MessageMetadata;
import lombok.Setter;

import java.util.Map;

/**
 * @author Jeongjin Kim
 * @since 2017-08-23
 */
public class ElementDataConverterSelectorImpl implements ElementDataConverterSelector {

    @Setter
    private Map<String, ElementDataConverter> converterMapper;

    @Override
    public ElementDataConverter getElementDataConverter(Object... objects) {
        if (objects.length > 0) {
            if (objects[0] instanceof MessageMetadata) {
                return converterMapper.get(MessageMetadata.class.cast(objects[0]).getDestinationSystemId());
            }
        }

        return null;
    }
}
