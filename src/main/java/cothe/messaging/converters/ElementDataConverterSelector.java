package cothe.messaging.converters;

public interface ElementDataConverterSelector {
    ElementDataConverter getElementDataConverter(Object ...objects);
}
