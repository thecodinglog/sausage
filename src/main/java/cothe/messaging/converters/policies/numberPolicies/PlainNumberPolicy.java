package cothe.messaging.converters.policies.numberPolicies;

/**
 * @author Jeongjin Kim
 * @since 2017-08-25
 */
public class PlainNumberPolicy implements NumberPolicy {
    @Override
    public String convert(Object data) {
        return data.toString();
    }
}
