package cothe.model;

import lombok.Setter;

import java.util.Map;

public class MessageBinderImpl implements MessageBinder {
    @Setter
    private ElementFormatterSelector elementFormatterSelector;


    @Override
    public Message bind(MessageMetadata messageMetadata, Map dataSource) {

        ElementFormatter formatter = elementFormatterSelector.getElementFormatter();

        Message message = new Message();

        for (Element element : messageMetadata.getMessageStructure()) {
            message.addElement(element.getId(), formatter.format(element.getType(), dataSource.get(element.getId())));
        }


        return message;
    }


}
