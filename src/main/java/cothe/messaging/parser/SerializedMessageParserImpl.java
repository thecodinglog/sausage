package cothe.messaging.parser;

import cothe.messaging.converter.ElementDataConverter;
import cothe.messaging.converter.ElementDataConverterSelector;
import cothe.messaging.model.*;
import lombok.NonNull;
import lombok.Setter;
import org.springframework.messaging.Message;

import java.util.*;

import static java.util.stream.Collectors.toList;

/**
 * @author Jeongjin Kim
 * @since 2017. 9. 8.
 */
public class SerializedMessageParserImpl implements MessageParser<String> {
    @Setter
    private ElementDataConverterSelector elementDataConverterSelector;

    public SerializedMessageParserImpl(@NonNull ElementDataConverterSelector elementDataConverterSelector) {
        this.elementDataConverterSelector = elementDataConverterSelector;
    }

    @Override
    public Map<String, Object> parse(MessageMetadata messageMetadata, Message<String> message) {
        ElementDataConverter converter = elementDataConverterSelector.getElementDataConverter(messageMetadata);

        Map<String, Object> result = new HashMap<>();

        if (converter == null) {
            throw new NullPointerException();
        }

        String delimiter = converter.getDelimiter().toString();

        List<FlatDataElement> flatDataElements = flatStructure(messageMetadata.getStructureElement(), null, null);
        List<Integer> sizes = flatDataElements.stream().map(flatDataElement -> flatDataElement.getDataElement().getLength()).collect(toList());

        Compartmental<String> compartmental = new CompartmentalByteLengthString(
                message.getPayload()
                , sizes
                , delimiter
                , converter.getCharset());

        for(int i=0; i<flatDataElements.size();i++){
            result.put(flatDataElements.get(i).getNewId(), converter.convertBack(flatDataElements.get(i).getDataElement(),compartmental.get(i)));
        }

        return result;

    }

    private List<FlatDataElement> flatStructure(
            StructureElement structureElement,
            Element parentElement,
            String stackedId
    ) {
        List<FlatDataElement> fde = new ArrayList<>();

        if (parentElement != null) {
            for (int i = 0; i < parentElement.getLength(); i++) {
                for (Element element : structureElement) {
                    if (element.getElementType() == ElementType.STRUCTURE) {
                        fde.addAll(flatStructure((StructureElement) element, element, stackedId + "_" + element.getId() + "_" + String.valueOf(i)));
                    } else {
                        fde.add(new FlatDataElement(stackedId + "_" + element.getId() + "_" + String.valueOf(i), (DataElement) element));
                    }
                }
            }
        } else {
            for (Element element : structureElement) {
                if (element.getElementType() == ElementType.STRUCTURE) {
                    fde.addAll(flatStructure((StructureElement) element, element, element.getId()));
                } else {
                    fde.add(new FlatDataElement(element.getId(), (DataElement) element));
                }
            }

        }

        return fde;
    }
}
