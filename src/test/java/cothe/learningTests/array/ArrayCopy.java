package cothe.learningTests.array;

import org.junit.Test;

import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.util.Arrays;

/**
 * @author Jeongjin Kim
 * @since 2017. 9. 11.
 */
public class ArrayCopy {
    @Test
    public void arrayCopy() throws UnsupportedEncodingException {
        String abc = "abcde";
        byte[] ba = abc.getBytes("euc-kr");
        byte[] re = Arrays.copyOfRange(ba, 1,3);
        String res = new String(re,  Charset.forName("euc-kr"));

        System.out.println(res);
    }
}
