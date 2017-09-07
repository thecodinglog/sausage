package cothe.messaging.converters.policies.booleanPolicies;

import cothe.messaging.model.DataElement;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author Jeongjin Kim
 * @since 2017-09-06
 */
public class FixedLengthRightPaddingYNBooleanPolicyTest {
    @Test
    public void padding() {
        FixedLengthRightPaddingYNBooleanPolicy fy = new FixedLengthRightPaddingYNBooleanPolicy();
        Assert.assertEquals(fy.convert("yes", new DataElement("d", null, null, 10, 0, null)), "Y         ");
        Assert.assertEquals(fy.convert("yes", new DataElement("d", null, null, 3, 0, null)), "Y  ");
        Assert.assertEquals(fy.convert("yes", new DataElement("d", null, null, 1, 0, null)), "Y");
        Assert.assertEquals(fy.convert("yes", new DataElement("d", null, null, 0, 0, null)), "");

    }

}