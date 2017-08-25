package cothe.learningTests.generics;

import org.junit.Test;

/**
 * @author Jeongjin Kim
 * @since 2017-08-25
 */
public class RunningTest {
    @Test
    public void run(){
        Binder binder = new CustomBinder();
        String result = binder.bind(new MapListConcator());
    }
}
