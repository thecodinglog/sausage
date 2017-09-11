package cothe.messaging.converter;

import cothe.messaging.model.DataElement;

import java.nio.charset.Charset;
import java.util.Locale;

public interface ElementDataConverter {
    String convert(DataElement element, Object data);
    <T> T convertBack(DataElement element, String data);
    CharSequence getDelimiter();
    Locale getLocale();
    Charset getCharset();

}
