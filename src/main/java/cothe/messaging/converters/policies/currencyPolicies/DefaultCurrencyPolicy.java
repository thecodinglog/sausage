package cothe.messaging.converters.policies.currencyPolicies;

import cothe.messaging.model.Element;

import java.text.NumberFormat;
import java.util.Locale;

/**
 * @author Jeongjin Kim
 * @since 2017-08-25
 */
public class DefaultCurrencyPolicy implements CurrencyPolicy {
    @Override
    public String convert(Object data) {
        return convert(data, null);
    }

    @Override
    public String convert(Object data, Element element) {

        String input = data.toString();

        NumberFormat currencyFormatter = NumberFormat.getCurrencyInstance(Locale.getDefault());

        return currencyFormatter.format(Double.parseDouble(input));
    }
}
