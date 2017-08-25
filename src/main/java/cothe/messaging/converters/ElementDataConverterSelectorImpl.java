package cothe.messaging.converters;

import cothe.messaging.model.MessageMetadata;

/**
 * @author Jeongjin Kim
 * @since 2017-08-23
 */
public class ElementDataConverterSelectorImpl implements ElementDataConverterSelector {

    @Override
    public ElementDataConverter getElementDataConverter(Object... objects) {
        if (objects.length > 0) {
            if(objects[0] instanceof MessageMetadata){
                if(MessageMetadata.class.cast(objects[0]).getDestinationSystemId().equals("Sys01")){
                    return new FixedLengthElementDataConverter();
                }else if(MessageMetadata.class.cast(objects[0]).getDestinationSystemId().equals("Sys02")){
                    return new LimitedLengthElementDataConverter();
                }
            }
        }

        return null;
    }
}
