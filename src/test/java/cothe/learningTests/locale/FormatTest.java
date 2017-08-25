package cothe.learningTests.locale;

import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 * @author Jeongjin Kim
 * @since 2017-08-25
 */
public class FormatTest {
    @Test
    public void dateFormat() throws ParseException {
        GregorianCalendar gregorianCalendar = new GregorianCalendar(2017,3,12,23,13,11);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMddHHmmss");

        if(gregorianCalendar instanceof Calendar){
            System.out.println(simpleDateFormat.format(((Calendar) gregorianCalendar).getTime()));
        }


        System.out.println(simpleDateFormat.parse("20231211121333"));



    }
}
