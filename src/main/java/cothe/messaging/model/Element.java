package cothe.messaging.model;

/**
 * @author Jeongjin Kim
 * @since 2017-09-01
 */
public interface Element {
    String getId();
    String getName();
    int getLength();
    ElementType getElementType();
}
