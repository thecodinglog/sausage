package cothe.messaging.bind;

import cothe.messaging.SerializedMessage;
import cothe.messaging.converters.ElementDataConverter;
import cothe.messaging.converters.ElementDataConverterSelector;
import cothe.messaging.model.Element;
import cothe.messaging.model.MessageMetadata;
import lombok.NonNull;
import lombok.Setter;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageHeaders;

import java.util.*;

public class SerializedMessageBinderImpl implements MessageBinder<String, Map.Entry<String, String>> {
    @Setter
    private ElementDataConverterSelector elementDataConverterSelector;

    public SerializedMessageBinderImpl(@NonNull ElementDataConverterSelector elementDataConverterSelector) {
        this.elementDataConverterSelector = elementDataConverterSelector;
    }


    @Override
    public Message<String> bind(MessageMetadata messageMetadata, Map<String, ?> dataSource, ListConcator<Map.Entry<String, String>> concator) {


        ElementDataConverter converter = elementDataConverterSelector.getElementDataConverter(messageMetadata);

        if (converter == null) {
            throw new NullPointerException();

        }

        List<Map.Entry<String, String>> temp = new ArrayList<>();

        for (Element element : messageMetadata.getMessageStructure()) {
            String data = converter.convert(element.getType(), dataSource.get(element.getId()));
            temp.add(new AbstractMap.SimpleEntry<>(element.getId(), data));
        }

        Map<String, Object> header = new HashMap<>();
        header.put("source", messageMetadata.getSourceSystemId());
        header.put("destination", messageMetadata.getDestinationSystemId());
        MessageHeaders messageHeaders = new MessageHeaders(header);

        Message<String> message = new SerializedMessage(concator.concat(temp), messageHeaders);

        return message;

    }

    private <T> void bindHelper(ListConcator<T> concator, List<T> list) {
        concator.concat(list);
    }
}
