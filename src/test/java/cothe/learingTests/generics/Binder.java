package cothe.learingTests.generics;

/**
 * @author Jeongjin Kim
 * @since 2017-08-24
 */
public interface Binder {
    String bind(String data, ListConcator<?> listConcator);
}
