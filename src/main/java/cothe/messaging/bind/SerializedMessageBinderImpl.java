package cothe.messaging.bind;

import cothe.domain.ElementType;
import cothe.messaging.SerializedMessage;
import cothe.messaging.converters.ElementDataConverter;
import cothe.messaging.converters.ElementDataConverterSelector;
import cothe.messaging.model.DataElement;
import cothe.messaging.model.Element;
import cothe.messaging.model.MessageMetadata;
import cothe.messaging.model.StructureElement;
import lombok.NonNull;
import lombok.Setter;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageHeaders;

import java.util.*;
import java.util.function.Function;

public class SerializedMessageBinderImpl implements MessageBinder<String, Map.Entry<String, String>> {
    @Setter
    private ElementDataConverterSelector elementDataConverterSelector;

    public SerializedMessageBinderImpl(@NonNull ElementDataConverterSelector elementDataConverterSelector) {
        this.elementDataConverterSelector = elementDataConverterSelector;
    }


    @Override
    public Message<String> bind(MessageMetadata messageMetadata, Map<String, ?> dataSource, CharSequence delimiter) {
        ElementDataConverter converter = elementDataConverterSelector.getElementDataConverter(messageMetadata);

        if (converter == null) {
            throw new NullPointerException();

        }

        List<Map.Entry<String, String>> temp = new ArrayList<>();

        StringJoiner stringJoiner = new StringJoiner(delimiter);

        convertRouting(messageMetadata.getStructureElement(), dataSource, converter, null, stringJoiner);

        Map<String, Object> header = new HashMap<>();
        header.put("source", messageMetadata.getSourceSystemId());
        header.put("destination", messageMetadata.getDestinationSystemId());
        MessageHeaders messageHeaders = new MessageHeaders(header);

        Message<String> message = new SerializedMessage(stringJoiner.toString(), messageHeaders);

        return message;

    }

    private void convertRouting(
            StructureElement structureElement,
            Map<String, ?> dataSource,
            ElementDataConverter converter,
            Element parentElement,
            StringJoiner stringJoiner
    ) {

        if (parentElement != null) {
            for (int i = 0; i < parentElement.getLength(); i++) {
                for (Element element : structureElement) {
                    if (element.getElementType() == ElementType.STRUCTURE) {
                        convertRouting((StructureElement) element, dataSource, converter, element, stringJoiner);
                    } else {
                        String value = converter.convert((DataElement)element, dataSource.get(parentElement.getId() + "_" + element.getId() + "_" + String.valueOf(i)));
                        stringJoiner.add(value == null ? "" : value);
                    }
                }
            }
        } else {
            for (Element element : structureElement) {
                if (element.getElementType() == ElementType.STRUCTURE) {
                    convertRouting((StructureElement) element, dataSource, converter, element, stringJoiner);
                } else {
                    String value = converter.convert((DataElement)element, dataSource.get(element.getId()));
                    stringJoiner.add(value == null ? "" : value);
                }
            }

        }
    }
}
