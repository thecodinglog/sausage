package cothe.messaging;

/**
 * @author Jeongjin Kim
 * @since 2017. 9. 19.
 */
public interface Message<T> {
    T getPayload();
    MessageHeaders getHeaders();
}
