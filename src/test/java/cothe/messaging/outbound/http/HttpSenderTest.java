package cothe.messaging.outbound.http;

import cothe.messaging.Message;
import cothe.messaging.MessageHeaders;
import cothe.messaging.outbound.TargetUrlResolver;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author Jeongjin Kim
 * @since 2017. 9. 22.
 */
public class HttpSenderTest {
    @Test
    public void send(){
        HttpSender httpSender = new HttpSender(messageHeaders -> "http://www.google.com");

        httpSender.setCharSet("utf-8");
        httpSender.sendMessage(new Message<String>() {
            @Override
            public String getPayload() {
                return "<tag>Sample payload</tag>";
            }

            @Override
            public MessageHeaders getHeaders() {
                return null;
            }
        });


    }

}