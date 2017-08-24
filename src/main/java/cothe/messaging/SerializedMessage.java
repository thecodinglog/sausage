package cothe.messaging;

import org.springframework.messaging.Message;
import org.springframework.messaging.MessageHeaders;

/**
 * @author Jeongjin Kim
 * @since 2017-08-23
 */
public class SerializedMessage implements Message<String> {
    private String payload;
    private MessageHeaders messageHeaders;

    public SerializedMessage(String payload, MessageHeaders messageHeaders) {
        this.payload = payload;
        this.messageHeaders = messageHeaders;
    }

    @Override
    public String getPayload() {
        return payload;
    }

    @Override
    public MessageHeaders getHeaders() {
        return messageHeaders;
    }


}
