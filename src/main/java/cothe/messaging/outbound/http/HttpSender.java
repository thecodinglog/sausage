package cothe.messaging.outbound.http;

import cothe.messaging.Message;
import cothe.messaging.exceptions.EncodingException;
import cothe.messaging.exceptions.RuntimeIOException;
import cothe.messaging.outbound.Sender;
import cothe.messaging.outbound.TargetUrlResolver;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.nio.charset.Charset;

/**
 * @author Jeongjin Kim
 * @since 2017. 9. 20.
 */
public class HttpSender implements Sender<String> {
    private TargetUrlResolver targetUrlResolver;

    private Charset charset;

    public void setCharSet(String charset) {
        this.charset = Charset.forName(charset);

    }

    public void setCharSet(Charset charset) {
        this.charset = charset;
    }

    public HttpSender(TargetUrlResolver targetUrlResolver) {
        this.targetUrlResolver = targetUrlResolver;

    }

    @Override
    public boolean sendMessage(Message<String> message) {
        if (charset == null) {
            charset = Charset.defaultCharset();
        }

        HttpPost httpPost = new HttpPost(targetUrlResolver.getUrl(message.getHeaders()));
        HttpEntity httpEntity = null;
        try {
            httpEntity = new StringEntity(
                    URLEncoder.encode(message.getPayload(), charset.displayName()),
                    charset);
        } catch (UnsupportedEncodingException e) {
            throw new EncodingException(e);
        }

        try (CloseableHttpClient httpClient = HttpClients.createDefault()) {

            httpPost.setEntity(httpEntity);

            try (CloseableHttpResponse httpResponse = httpClient.execute(httpPost)) {
                int statusCode = httpResponse.getStatusLine().getStatusCode();

                if (statusCode >= 200 && statusCode < 300) {
                    return true;
                }
            }

        } catch (IOException e) {
            throw new RuntimeIOException(e);
        }

        return false;
    }
}
