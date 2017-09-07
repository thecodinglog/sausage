package cothe.messaging.converters.policies.datetimePolicies;

import cothe.messaging.converters.policies.ParameterizedPolicyTest;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

/**
 * @author Jeongjin Kim
 * @since 2017-09-06
 */
@RunWith(Parameterized.class)
public class FixedLengthRightPaddingDateTimePolicyTest extends ParameterizedPolicyTest {
    public FixedLengthRightPaddingDateTimePolicyTest(Object input, int inputLength, int precision, String expected) {
        super(input, inputLength, precision, expected);
    }

    @Override
    public void init() {
        this.convertingPolicy = new FixedLengthRightPaddingDateTimePolicy();
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {"2017-01-05 23:21:11", 20, -1, "20170105232111000   "},
                {"2017-01-05 23:21:11", 7, -1, "201701 "},
                {"2017-01-05 23:21:11", 8, -1, "20170105"}

        });
    }
}