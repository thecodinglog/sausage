package cothe.messaging.converter.policies.datetimePolicies;

import cothe.messaging.converter.policies.ConvertingPolicy;
import cothe.messaging.converter.policies.ParameterizedPolicyTest;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Arrays;
import java.util.Collection;

/**
 * @author Jeongjin Kim
 * @since 2017-09-06
 */
public class FixedLengthRightPaddingDateTimePolicyTest extends ParameterizedPolicyTest {

    public FixedLengthRightPaddingDateTimePolicyTest(Object input, int inputLength, int precision, String expected) {
        super(input, inputLength, precision, expected);
    }

    @Override
    public void init() {
        //this.convertingPolicy = applicationContext.getBean("fixedLengthDatetimePolicy", ConvertingPolicy.class);
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