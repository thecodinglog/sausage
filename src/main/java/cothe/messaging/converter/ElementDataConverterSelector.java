package cothe.messaging.converter;

public interface ElementDataConverterSelector {
    ElementDataConverter getElementDataConverter(Object ...objects);
}
