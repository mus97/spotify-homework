import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class GetArticles {
    private static final Logger logger = LogManager.getLogger();

    @Test
    public void testGetArticles() throws IOException {
        HttpGet request = new HttpGet("https://api.spotify.com/v1/me");
        CloseableHttpResponse response = HttpClientBuilder.create().build().execute(request);
        String body = response.toString();
        logger.info(body);
        System.out.println(body);
    }
}


