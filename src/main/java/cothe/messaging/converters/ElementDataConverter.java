package cothe.messaging.converters;

import cothe.messaging.model.DataElement;

public interface ElementDataConverter {
    String convert(DataElement element, Object data);
    CharSequence getDelimiter();
}
