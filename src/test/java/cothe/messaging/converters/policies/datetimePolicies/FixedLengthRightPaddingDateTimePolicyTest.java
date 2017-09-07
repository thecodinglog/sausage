package cothe.messaging.converters.policies.datetimePolicies;

import cothe.messaging.converters.policies.currencyPolicies.FixedLengthLeftPaddingCurrencyPolicy;
import cothe.messaging.model.DataElement;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author Jeongjin Kim
 * @since 2017-09-06
 */
public class FixedLengthRightPaddingDateTimePolicyTest {
    @Test
    public void convert(){
        FixedLengthRightPaddingDateTimePolicy policy = new FixedLengthRightPaddingDateTimePolicy();
        String data = policy.convert("2017-01-05 23:21:11", new DataElement(null,null, null, 20, -1, null));
        System.out.println("["+ data + "]") ;

    }

}