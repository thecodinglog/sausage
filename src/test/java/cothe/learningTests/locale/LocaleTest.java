package cothe.learningTests.locale;

import org.junit.Test;

import java.util.Locale;

/**
 * @author Jeongjin Kim
 * @since 2017-08-25
 */
public class LocaleTest {
    @Test
    public void getDefaultLocale(){
        System.out.println(Locale.getDefault().toString());

    }
}
