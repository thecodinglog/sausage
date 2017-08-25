package cothe.messaging.converters.policies.stringPolicies;

/**
 * @author Jeongjin Kim
 * @since 2017-08-25
 */
public class PlainStringPolicy implements StringPolicy {
    @Override
    public String convert(Object data) {
        return data.toString();
    }
}
