package cothe.messaging.exceptions;

/**
 * @author Jeongjin Kim
 * @since 2017-09-07
 */
public class UnsupportedFormatException extends RuntimeException {
    public UnsupportedFormatException(String message, Throwable e) {
        super(message, e);
    }
    public UnsupportedFormatException(String message) {
        super(message);
    }
    public UnsupportedFormatException(Throwable e) {
        super(e);
    }
}
