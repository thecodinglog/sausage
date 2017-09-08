package cothe.messaging.converters.policies.currencyPolicies;

import cothe.messaging.model.DataElement;

/**
 * @author Jeongjin Kim
 * @since 2017-08-25
 */
public class DefaultCurrencyPolicy implements CurrencyPolicy {
    @Override
    public String convert(Object data, DataElement dataElement) {

        if(data == null){
            return "";
        }

        //NumberFormat numberFormat = NumberFormat.getNumberInstance(Locale.getDefault());
        //NumberFormat currencyFormatter = NumberFormat.getCurrencyInstance(Locale.getDefault());

        //return (numberFormat.format(Double.parseDouble(input)) + dataElement.getUnit());
        return data.toString();

    }
}
