package cothe.messaging.converter.policies;

import cothe.messaging.model.DataElement;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.nio.charset.Charset;
import java.util.Locale;

/**
 * Policy를 테스트기 위한 Base Class 이다.
 * 이 클래스를 상속 하여
 * <code>
 *
 * @author Jeongjin Kim
 * @Parameterized.Parameters public static Collection<Object[]> data() {
 * return Arrays.asList(new Object[][]{
 * { Data : Object, 길이 : int, 정밀도 : int , 예상값 : String},
 * });
 * }
 * <p>
 * </code>
 * static method 를 작성해야 함.
 * <p>
 * init method에 테스트할 Policy Instance를 할당해 줘야 함
 * @since 2017-09-07
 */
@RunWith(Parameterized.class)
public abstract class ParameterizedPolicyTest {
    protected ConvertingPolicy convertingPolicy;

    private Object input;
    private int inputLength;
    private String expected;
    private int precision;
    private Charset charset;
    private Locale locale;

    public ParameterizedPolicyTest(Object input, int inputLength, int precision, Charset charset, Locale locale, String expected) {
        this.input = input;
        this.inputLength = inputLength;
        this.expected = expected;
        this.precision = precision;
        this.charset = charset;
        this.locale = locale;
    }
    public ParameterizedPolicyTest(Object input, int inputLength, int precision, String charset, Locale locale, String expected) {
        this.input = input;
        this.inputLength = inputLength;
        this.expected = expected;
        this.precision = precision;
        this.charset = Charset.forName(charset);
        this.locale = locale;
    }

    public ParameterizedPolicyTest(Object input, int inputLength, int precision, String expected) {
        this.input = input;
        this.inputLength = inputLength;
        this.expected = expected;
        this.precision = precision;

    }


    @Before
    abstract public void init();

    @Test
    public void convert() throws Exception {
        String data = convertingPolicy.convert(input, new DataElement(null, null, null, inputLength, precision, null), charset, locale);
        Assert.assertEquals(expected, data);
    }
}
