package cothe.messaging.exceptions;

/**
 * @author Jeongjin Kim
 * @since 2017-09-07
 */
public class RuntimeIOException extends RuntimeException {
    public RuntimeIOException(String message, Throwable e) {
        super(message, e);
    }
    public RuntimeIOException(String message) {
        super(message);
    }
    public RuntimeIOException(Throwable e) {
        super(e);
    }
}
