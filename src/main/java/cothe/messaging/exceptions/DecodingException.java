package cothe.messaging.exceptions;

/**
 * @author Jeongjin Kim
 * @since 2017-09-07
 */
public class DecodingException extends RuntimeException {
    public DecodingException(String message, Throwable e) {
        super(message, e);
    }
    public DecodingException(String message) {
        super(message);
    }
    public DecodingException(Throwable e) {
        super(e);
    }
}
