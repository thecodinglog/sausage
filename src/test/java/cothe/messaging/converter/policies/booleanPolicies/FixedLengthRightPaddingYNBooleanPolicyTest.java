package cothe.messaging.converter.policies.booleanPolicies;

import cothe.messaging.converter.policies.ParameterizedPolicyTest;
import cothe.messaging.model.DataElement;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

/**
 * @author Jeongjin Kim
 * @since 2017-09-06
 */
public class FixedLengthRightPaddingYNBooleanPolicyTest extends ParameterizedPolicyTest {
    public FixedLengthRightPaddingYNBooleanPolicyTest(Object input, int inputLength, int precision, String expected) {
        super(input, inputLength, precision, expected);
    }

    @Test
    public void padding() {
        FixedLengthRightPaddingYNBooleanPolicy fy = new FixedLengthRightPaddingYNBooleanPolicy();
        Assert.assertEquals(fy.convert("yes", new DataElement("d", null, null, 10, 0, null)), "Y         ");
        Assert.assertEquals(fy.convert("yes", new DataElement("d", null, null, 3, 0, null)), "Y  ");
        Assert.assertEquals(fy.convert("yes", new DataElement("d", null, null, 1, 0, null)), "Y");
        Assert.assertEquals(fy.convert("yes", new DataElement("d", null, null, 0, 0, null)), "");

    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {"yes", 10, -1, "Y         "},
                {"yes", 3, -1, "Y  "},
                {"yes", 1, -1, "Y"},
                {"yes", 0, -1, ""},
        });
    }

    @Override
    public void init() {
        this.convertingPolicy = new FixedLengthRightPaddingYNBooleanPolicy();
    }
}