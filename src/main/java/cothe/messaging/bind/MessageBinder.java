package cothe.messaging.bind;


import cothe.messaging.model.MessageMetadata;
import org.springframework.messaging.Message;

import java.util.Map;

public interface MessageBinder<T> {
    Message<T> bind(MessageMetadata messageMetadata, Map<String, ?> dataSource);

}
