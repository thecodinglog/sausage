package cothe.messaging.converters.policies.stringPolicies;

import cothe.messaging.converters.policies.ConvertingPolicy;
import cothe.messaging.converters.policies.ParameterizedPolicyTest;
import org.junit.Test;
import org.junit.runners.Parameterized;

import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.*;

/**
 * @author Jeongjin Kim
 * @since 2017. 9. 8.
 */
public class EUCKrFixedByteLengthRightPaddingStringPolicyTest extends ParameterizedPolicyTest {


    public EUCKrFixedByteLengthRightPaddingStringPolicyTest(Object input, int inputLength, int precision, String expected) {
        super(input, inputLength, precision, expected);
    }

    @Override
    public void init() {

        FixedByteLengthRightPaddingStringPolicy policy = new FixedByteLengthRightPaddingStringPolicy();
        try {
            policy.setCharset(Charset.forName("EUC-KR"));
        } catch (Exception e) {
            e.printStackTrace();
        }
        this.convertingPolicy = policy;

    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {"한글이", 3, -1, "한 "},
                {"a한글", 3, -1, "a한"},
                {"한글", 10, -1, "한글      "},

        });
    }
}