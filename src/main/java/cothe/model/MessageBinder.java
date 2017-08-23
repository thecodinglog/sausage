package cothe.model;

import java.util.Map;

public interface MessageBinder {
    Message bind(MessageMetadata messageMetadata, Map dataSource);

}
