package cothe.messaging.exceptions;

/**
 * @author Jeongjin Kim
 * @since 2017-09-07
 */
public class NotEnoughLengthException extends RuntimeException {
    public NotEnoughLengthException(String message, Throwable e) {
        super(message, e);
    }
    public NotEnoughLengthException(String message) {
        super(message);
    }
    public NotEnoughLengthException(Throwable e) {
        super(e);
    }

}
