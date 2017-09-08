package cothe.learningTests.generics;

import org.apache.commons.lang3.StringUtils;
import org.junit.Test;

/**
 * @author Jeongjin Kim
 * @since 2017-09-06
 */
public class ApacheStringUtilTests {
    @Test
    public void padding(){
        System.out.println(StringUtils.rightPad("ha", 10));;


    }
    @Test
    public void shortDataButPadding(){
        System.out.println(StringUtils.rightPad("hello", 3));

    }
}
