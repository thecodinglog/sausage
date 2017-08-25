package cothe.messaging.converters.policies.currencyPolicies;

import java.text.NumberFormat;
import java.util.Locale;

/**
 * @author Jeongjin Kim
 * @since 2017-08-25
 */
public class DefaultCurrencyPolicy implements CurrencyPolicy {
    @Override
    public String convert(Object data) {
        String input = data.toString();

        NumberFormat currencyFormatter = NumberFormat.getCurrencyInstance(Locale.getDefault());

        return currencyFormatter.format(Double.parseDouble(input));
    }
}
