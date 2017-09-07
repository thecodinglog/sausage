package cothe.messaging.converters.policies.currencyPolicies;

import cothe.messaging.model.DataElement;
import org.junit.Test;

/**
 * @author Jeongjin Kim
 * @since 2017-09-06
 */
public class FixedLengthLeftPaddingCurrencyPolicyTest {
    @Test
    public void convert(){
        FixedLengthLeftPaddingCurrencyPolicy policy = new FixedLengthLeftPaddingCurrencyPolicy();
        String data = policy.convert("30.23", new DataElement(null,null, null, 10, -1, "KRW"));
        System.out.println(data);

    }


}