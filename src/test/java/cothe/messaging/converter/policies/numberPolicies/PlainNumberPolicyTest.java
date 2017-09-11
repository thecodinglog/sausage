package cothe.messaging.converter.policies.numberPolicies;

import cothe.messaging.converter.policies.ParameterizedPolicyTest;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

/**
 * @author Jeongjin Kim
 * @since 2017-09-07
 */
public class PlainNumberPolicyTest extends ParameterizedPolicyTest {
    public PlainNumberPolicyTest(Object input, int inputLength, int precision, String expected) {
        super(input, inputLength, precision, expected);
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {"3", 3, 0, "3"},
                {"3.1415", 3, 0, "3"},
                {"3.1415", 3, 2, "3.14"},
                {"-3.1415", 3, 2, "-3.14"},
                {3, 3, 0, "3"},
                {3.3, 3, 0, "3"},
                {3.3, 3, 0, "3"},
                {3.8, 3, 0, "3"},
                {-3.8, 3, 0, "-3"},
                {-3.8, 3, 1, "-3.8"},
                {-3.8, 3, 2, "-3.80"},
                {-332.8384, 3, 2, "-332.83"},
                {332.8384, 3, 2, "332.83"},
                {332.8384, 3, 2, "332.83"},

        });
    }

    @Override
    public void init() {
        this.convertingPolicy = new PlainNumberPolicy();
    }
}
