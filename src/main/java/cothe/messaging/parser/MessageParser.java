package cothe.messaging.parser;

import cothe.messaging.Message;
import cothe.messaging.model.MessageMetadata;

import java.util.Map;

/**
 * @author Jeongjin Kim
 * @since 2017. 9. 8.
 */
public interface MessageParser<T> {
     Map<String, Object> parse(MessageMetadata messageMetadata, Message<T> message);
}
