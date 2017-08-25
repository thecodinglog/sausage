package cothe.converters;

import cothe.messaging.converters.policies.DatetimePolicies.DefaultDateTimePolicy;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author Jeongjin Kim
 * @since 2017-08-25
 */
public class DafaultDateTimePolicyTest {
    @Test
    public void stringTypeDateConvert(){
        DefaultDateTimePolicy defaultDateTimePolicy = new DefaultDateTimePolicy();

        Assert.assertEquals("20171011231122333", defaultDateTimePolicy.convert("2017-10-11 23:11:22,333"));
        Assert.assertEquals("20171011231122000", defaultDateTimePolicy.convert("20171011231122"));
        Assert.assertEquals("20171011023112000", defaultDateTimePolicy.convert("20171011 23112"));
    }
    @Test(expected = UnsupportedOperationException.class)
    public void stringTypeDateConvertForException(){
        DefaultDateTimePolicy defaultDateTimePolicy = new DefaultDateTimePolicy();
        Assert.assertEquals("20171011023112000", defaultDateTimePolicy.convert("2017-10-1123112"));


    }
}
