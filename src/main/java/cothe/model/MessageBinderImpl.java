package cothe.model;

import lombok.NonNull;
import lombok.Setter;

import java.util.Map;

public class MessageBinderImpl implements MessageBinder {
    @Setter
    private ElementDataConverterSelector elementDataConverterSelector;

    public MessageBinderImpl(@NonNull ElementDataConverterSelector elementDataConverterSelector) {
        this.elementDataConverterSelector = elementDataConverterSelector;
    }

    @Override
    public Message bind(@NonNull MessageMetadata messageMetadata,@NonNull Map dataSource) {
        ElementDataConverter converter = elementDataConverterSelector.getElementDataConverter();

        if(converter == null){
            throw new NullPointerException();

        }

        Message message = new Message();

        for (Element element : messageMetadata.getMessageStructure()) {
            message.addElement(element.getId(), converter.convert(element.getType(), dataSource.get(element.getId())));
        }


        return message;
    }


}
