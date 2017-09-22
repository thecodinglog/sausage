package cothe.messaging.outbound;

import cothe.messaging.MessageHeaders;

/**
 * @author Jeongjin Kim
 * @since 2017. 9. 21.
 */
public interface TargetUrlResolver {
    String getUrl(MessageHeaders messageHeaders);
}
