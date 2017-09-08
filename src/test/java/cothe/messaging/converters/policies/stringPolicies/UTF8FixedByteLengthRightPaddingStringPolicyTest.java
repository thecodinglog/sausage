package cothe.messaging.converters.policies.stringPolicies;

import cothe.messaging.converters.policies.ParameterizedPolicyTest;
import org.junit.Test;
import org.junit.runners.Parameterized;

import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.Collection;

/**
 * @author Jeongjin Kim
 * @since 2017. 9. 8.
 */
public class UTF8FixedByteLengthRightPaddingStringPolicyTest extends ParameterizedPolicyTest {


    public UTF8FixedByteLengthRightPaddingStringPolicyTest(Object input, int inputLength, int precision, String expected) {
        super(input, inputLength, precision, expected);
    }

    @Override
    public void init() {

        FixedByteLengthRightPaddingStringPolicy policy = new FixedByteLengthRightPaddingStringPolicy();
        try {
            policy.setCharset(Charset.forName("UTF-8"));
        } catch (Exception e) {
            e.printStackTrace();
        }
        this.convertingPolicy = policy;

    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {"한글이", 3, -1, "한"},
                {"a한글", 3, -1, "a  "},
                {"한글", 10, -1, "한글    "},

        });
    }


}