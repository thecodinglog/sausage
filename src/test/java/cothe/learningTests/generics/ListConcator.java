package cothe.learningTests.generics;

import java.util.List;

/**
 * @author Jeongjin Kim
 * @since 2017-08-24
 */
public interface ListConcator<T>{
    String concat(List<T> list);
}
