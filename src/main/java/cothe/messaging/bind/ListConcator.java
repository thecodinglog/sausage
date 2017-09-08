package cothe.messaging.bind;

import java.util.List;

/**
 * @author Jeongjin Kim
 * @since 2017-08-24
 */
@Deprecated
public interface ListConcator<T> {
    String concat(List<T> list);
}
