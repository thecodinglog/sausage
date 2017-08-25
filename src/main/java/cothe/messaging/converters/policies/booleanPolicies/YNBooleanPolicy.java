package cothe.messaging.converters.policies.booleanPolicies;

/**
 * @author Jeongjin Kim
 * @since 2017-08-25
 */
public class YNBooleanPolicy implements BooleanPolicy {
    @Override
    public String convert(Object data) {
        String input = data.toString();
        switch (input.toLowerCase()) {
            case "true":
            case "yes":
            case "y":
            case "1":
                return "Y";
            case "false":
            case "no":
            case "n":
            case "0":
                return "N";
            default:
                    throw new UnsupportedOperationException();
        }
    }
}
