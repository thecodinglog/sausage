package cothe.messaging.parser;

import java.nio.charset.Charset;

/**
 * @author Jeongjin Kim
 * @since 2017. 9. 8.
 */
public interface Compartmental<T> extends Iterable<T> {
    int getCompartmentSize();
    int getByteLength(Charset charset, boolean exceptDelimiter);


}
