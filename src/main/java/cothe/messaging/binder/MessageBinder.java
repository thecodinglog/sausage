package cothe.messaging.binder;


import cothe.messaging.Message;
import cothe.messaging.model.MessageMetadata;

import java.util.Map;

public interface MessageBinder<T> {
    Message<T> bind(MessageMetadata messageMetadata, Map<String, ?> dataSource);

}
