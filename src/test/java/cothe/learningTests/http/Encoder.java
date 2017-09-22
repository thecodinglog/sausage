package cothe.learningTests.http;

import org.junit.Test;

import java.nio.charset.Charset;

/**
 * @author Jeongjin Kim
 * @since 2017. 9. 22.
 */
public class Encoder {
    @Test
    public void charsetName() {
        Charset charset =
                Charset.forName("utf-8");

        System.out.println(charset.displayName());

    }
}
