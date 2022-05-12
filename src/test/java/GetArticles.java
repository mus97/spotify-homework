import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class GetArticles {

    @Test
    public void testGetArticles() throws IOException {
        HttpGet request = new HttpGet("https://api.reverb.com/api/articles");
        CloseableHttpResponse response = HttpClientBuilder.create().build().execute(request);
        assertEquals(200, response.getStatusLine().getStatusCode());
    }
}


