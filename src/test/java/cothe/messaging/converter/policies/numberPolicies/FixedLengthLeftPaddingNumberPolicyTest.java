package cothe.messaging.converter.policies.numberPolicies;

import cothe.messaging.converter.policies.ParameterizedPolicyTest;
import cothe.messaging.exceptions.NotEnoughLengthException;
import cothe.messaging.model.DataElement;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

/**
 * @author Jeongjin Kim
 * @since 2017-09-07
 */
@RunWith(Parameterized.class)
public class FixedLengthLeftPaddingNumberPolicyTest extends ParameterizedPolicyTest {
    public FixedLengthLeftPaddingNumberPolicyTest(Object input, int inputLength, int precision, String expected) {
        super(input, inputLength, precision, expected);
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {"3", 3, 0, "  3"},
                {3, 3, 0, "  3"},
                {-3, 3, 0, " -3"},
                {"3", 3, -1, "  3"},
                {"3.0", 3, 0, "  3"},
                {"3.1", 8, 3, "   3.100"},
                {3233.23252323, 8, 3, "3233.232"},
        });
    }

    @Override
    public void init() {
        this.convertingPolicy = new FixedLengthLeftPaddingNumberPolicy();
    }

    @Test(expected = NotEnoughLengthException.class)
    public void exception() {
        String data = convertingPolicy.convert(32.33, new DataElement(null, null, null, 3, 1, null));
        // Assert.assertEquals(expected, data);
    }
}