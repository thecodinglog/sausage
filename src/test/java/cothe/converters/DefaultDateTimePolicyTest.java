package cothe.converters;

import cothe.messaging.converters.policies.datetimePolicies.DefaultDateTimePolicy;
import cothe.messaging.exceptions.UnsupportedFormatException;
import cothe.messaging.model.DataElement;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author Jeongjin Kim
 * @since 2017-08-25
 */
public class DefaultDateTimePolicyTest {
    @Test
    public void stringTypeDateConvert(){
        DefaultDateTimePolicy defaultDateTimePolicy = new DefaultDateTimePolicy();

        Assert.assertEquals("20171011231122333", defaultDateTimePolicy.convert("2017-10-11 23:11:22,333",new DataElement(null,null,null,20,-1,null)));
        Assert.assertEquals("20171011231122000", defaultDateTimePolicy.convert("20171011231122",new DataElement(null,null,null,20,-1,null)));
        Assert.assertEquals("20171011023112000", defaultDateTimePolicy.convert("20171011 23112",new DataElement(null,null,null,20,-1,null)));
        Assert.assertEquals("20171011", defaultDateTimePolicy.convert("20171011 23112",new DataElement(null,null,null,9,-1,null)));
    }
    @Test(expected = UnsupportedFormatException.class)
    public void stringTypeDateConvertForException(){
        DefaultDateTimePolicy defaultDateTimePolicy = new DefaultDateTimePolicy();
        Assert.assertEquals("20171011023112000", defaultDateTimePolicy.convert("20d171044rfd11231124ddddddd",new DataElement(null,null,null,20,-1,null)));


    }
}
