package cothe.messaging.converters.policies.numberPolicies;

import cothe.messaging.model.DataElement;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * @author Jeongjin Kim
 * @since 2017-08-25
 */
public class PlainNumberPolicy implements NumberPolicy {
    @Override
    public String convert(Object data, DataElement dataElement) {
        if (data == null) {
            return "";
        }

        int precision = dataElement.getPrecision();
        double number = Double.parseDouble(data.toString());
        if (precision > 0) {
            return BigDecimal.valueOf(number)
                    .setScale(precision, RoundingMode.DOWN)
                    .toString();
        } else {
            return String.valueOf((int) number);
        }
    }
}
