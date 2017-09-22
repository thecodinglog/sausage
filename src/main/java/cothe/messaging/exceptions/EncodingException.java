package cothe.messaging.exceptions;

/**
 * @author Jeongjin Kim
 * @since 2017-09-07
 */
public class EncodingException extends RuntimeException {
    public EncodingException(String message, Throwable e) {
        super(message, e);
    }
    public EncodingException(String message) {
        super(message);
    }
    public EncodingException(Throwable e) {
        super(e);
    }
}
