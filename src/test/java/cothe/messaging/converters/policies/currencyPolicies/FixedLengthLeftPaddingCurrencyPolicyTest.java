package cothe.messaging.converters.policies.currencyPolicies;

import cothe.messaging.converters.policies.ParameterizedPolicyTest;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

/**
 * @author Jeongjin Kim
 * @since 2017-09-06
 */
public class FixedLengthLeftPaddingCurrencyPolicyTest extends ParameterizedPolicyTest {
    public FixedLengthLeftPaddingCurrencyPolicyTest(Object input, int inputLength, int precision, String expected) {
        super(input, inputLength, precision, expected);
    }

    @Override
    public void init() {
        this.convertingPolicy = new FixedLengthLeftPaddingCurrencyPolicy();
    }
    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {"30.23", 10, -1, "     30.23"},


        });
    }
}