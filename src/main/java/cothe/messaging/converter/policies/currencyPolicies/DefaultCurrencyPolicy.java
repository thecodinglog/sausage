package cothe.messaging.converter.policies.currencyPolicies;

import cothe.messaging.model.DataElement;

import java.nio.charset.Charset;
import java.util.Locale;

/**
 * @author Jeongjin Kim
 * @since 2017-08-25
 */
public class DefaultCurrencyPolicy implements CurrencyPolicy {
    @Override
    public String convert(Object data, DataElement dataElement, Charset charset, Locale locale) {

        if(data == null){
            return "";
        }

        //NumberFormat numberFormat = NumberFormat.getNumberInstance(Locale.getDefault());
        //NumberFormat currencyFormatter = NumberFormat.getCurrencyInstance(Locale.getDefault());

        //return (numberFormat.format(Double.parseDouble(input)) + dataElement.getUnit());
        return data.toString();

    }

    @Override
    public Object convertBack(String data, DataElement dataElement, Charset charset, Locale locale) {
        return data.trim();
    }
}
