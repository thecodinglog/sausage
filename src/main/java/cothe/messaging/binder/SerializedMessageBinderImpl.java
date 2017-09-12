package cothe.messaging.binder;

import cothe.messaging.model.ElementType;
import cothe.messaging.SerializedMessage;
import cothe.messaging.converter.ElementDataConverter;
import cothe.messaging.converter.ElementDataConverterSelector;
import cothe.messaging.model.DataElement;
import cothe.messaging.model.Element;
import cothe.messaging.model.MessageMetadata;
import cothe.messaging.model.StructureElement;
import lombok.NonNull;
import lombok.Setter;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageHeaders;

import java.util.*;

public class SerializedMessageBinderImpl implements MessageBinder<String> {
    @Setter
    private ElementDataConverterSelector elementDataConverterSelector;

    public SerializedMessageBinderImpl(@NonNull ElementDataConverterSelector elementDataConverterSelector) {
        this.elementDataConverterSelector = elementDataConverterSelector;
    }


    @Override
    public Message<String> bind(MessageMetadata messageMetadata, Map<String, ?> dataSource) {
        ElementDataConverter converter = elementDataConverterSelector.getElementDataConverter(messageMetadata);

        if (converter == null) {
            throw new NullPointerException();

        }

        StringJoiner stringJoiner = convertRouting(messageMetadata.getStructureElement(), dataSource, converter, null, null);

        Map<String, Object> header = new HashMap<>();
        header.put("source", messageMetadata.getSourceSystemId());
        header.put("destination", messageMetadata.getDestinationSystemId());
        MessageHeaders messageHeaders = new MessageHeaders(header);

        return new SerializedMessage(stringJoiner.toString(), messageHeaders);

    }

    private StringJoiner convertRouting(
            StructureElement structureElement,
            Map<String, ?> dataSource,
            ElementDataConverter converter,
            Element parentElement,
            String stackedId
    ) {
        StringJoiner stringJoiner = new StringJoiner(converter.getDelimiter());

        if (parentElement != null) {
            for (int i = 0; i < parentElement.getLength(); i++) {
                for (Element element : structureElement) {
                    if (element.getElementType() == ElementType.STRUCTURE) {
                        stringJoiner.merge(convertRouting((StructureElement) element, dataSource, converter, element, stackedId + "_" + element.getId() + "_" + String.valueOf(i)));
                    } else {
                        //System.out.println("Find Key : [" + stackedId + "_" + element.getId() + "_" + String.valueOf(i) + "]");
                        String value = converter.convert((DataElement) element, dataSource.get(stackedId + "_" + element.getId() + "_" + String.valueOf(i)));
                        stringJoiner.add(value == null ? "" : value);
                    }
                }
            }
        } else {
            for (Element element : structureElement) {
                if (element.getElementType() == ElementType.STRUCTURE) {
                    stringJoiner.merge(convertRouting((StructureElement) element, dataSource, converter, element, element.getId()));
                } else {
                    //System.out.println("Find Key : [" + element.getId() + "]");
                    String value = converter.convert((DataElement) element, dataSource.get(element.getId()));
                    stringJoiner.add(value == null ? "" : value);
                }
            }

        }

        return stringJoiner;
    }
}
