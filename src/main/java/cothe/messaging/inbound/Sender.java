package cothe.messaging.inbound;

import cothe.messaging.Message;

/**
 * @author Jeongjin Kim
 * @since 2017. 9. 19.
 */
public interface Sender<T> {
    boolean sendMessage(Message<T> message);
}
