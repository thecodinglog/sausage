package cothe.messaging.converter.policies.stringPolicies;

import cothe.messaging.converter.policies.ParameterizedPolicyTest;
import org.junit.runners.Parameterized;

import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.Collection;
import java.util.Locale;

/**
 * @author Jeongjin Kim
 * @since 2017. 9. 8.
 */
public class EUCKrFixedByteLengthRightPaddingStringPolicyTest extends ParameterizedPolicyTest {


    public EUCKrFixedByteLengthRightPaddingStringPolicyTest(Object input, int inputLength, int precision, String charset, Locale locale, String expected) {
        super(input, inputLength, precision, charset, locale, expected);
    }

    @Override
    public void init() {


        this.convertingPolicy = new FixedByteLengthRightPaddingStringPolicy();;

    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {"한글이", 3, -1,"euc-kr",null, "한 "},
                {"a한글", 3, -1,"euc-kr",null, "a한"},
                {"한글", 10, -1,"euc-kr",null, "한글      "},

        });
    }
}