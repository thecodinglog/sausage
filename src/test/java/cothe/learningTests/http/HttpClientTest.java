package cothe.learningTests.http;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.junit.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Jeongjin Kim
 * @since 2017. 9. 20.
 */
public class HttpClientTest {
    @Test
    public void request() throws IOException {
        CloseableHttpClient httpClient = HttpClients.createDefault();
        try {
            HttpPost httpPost = new HttpPost("http://www.google.com");

            System.out.println("Executing request " + httpPost.getRequestLine());

            List<NameValuePair> nvps = new ArrayList<NameValuePair>();
            nvps.add(new BasicNameValuePair("", "My Test Message"));
            nvps.add(new BasicNameValuePair("password", "secret"));

            //HttpEntity httpEntity = new StringEntity("my custom message", "UTF-8");

            HttpEntity httpEntity = new UrlEncodedFormEntity(nvps);



            httpPost.setEntity(httpEntity);

            System.out.println("Req:"+EntityUtils.toString(httpEntity));

            HttpResponse httpResponse = httpClient.execute(httpPost);



            HttpEntity rspEntity = httpResponse.getEntity();



            EntityUtils.consume(rspEntity);
            System.out.println("Rsp:"+EntityUtils.toString(rspEntity));




        } catch (IOException e) {
        } finally {
            try {
                httpClient.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}
