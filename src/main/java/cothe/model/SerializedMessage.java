package cothe.model;

import org.springframework.messaging.Message;
import org.springframework.messaging.MessageHeaders;

/**
 * @author Jeongjin Kim
 * @since 2017-08-23
 */
public class SerializedMessage implements Message<String> {

    @Override
    public String getPayload() {
        return null;
    }

    @Override
    public MessageHeaders getHeaders() {
        return null;
    }
}
