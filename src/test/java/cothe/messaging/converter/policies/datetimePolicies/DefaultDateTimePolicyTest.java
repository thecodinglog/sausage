package cothe.messaging.converter.policies.datetimePolicies;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author Jeongjin Kim
 * @since 2017. 9. 12.
 */

public class DefaultDateTimePolicyTest {
    @Test
    public void convertBack(){
        DateTimePolicy dateTimePolicy = new DefaultDateTimePolicy();

        Object date = dateTimePolicy.convertBack("20161023212233111", null);
        System.out.println(date);

        date = dateTimePolicy.convertBack("20161023", null);
        System.out.println(date);


        date = dateTimePolicy.convertBack("20161023212233", null);
        System.out.println(date);

        date = dateTimePolicy.convertBack("201610232122", null);
        System.out.println(date);

    }

}