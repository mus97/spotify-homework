import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.message.BasicHeader;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class GetArticles {
    private static final Logger logger = LogManager.getLogger();

    @Test
    public void testGetArticles() throws IOException {
        String token = "BQCm2aCXRU4fPnE_DT0ZXteV8CYUm7MdrN5hS4m0IgQ34wsSw6HpgnN5DJZMHHD9WBQwNhNzGi22dgjTxGvBHTGYN0fq1Nlvkd6KjNvteiXNvt9PkL9V-NKsVlj-JB9YrzeKozaDU1RjYYQCS-M-MDsO-DfbbHBL56o";

        HttpGet request = new HttpGet("https://api.spotify.com/v1/me");
        //CloseableHttpResponse response = HttpClientBuilder.create().build().execute(request);
        CloseableHttpResponse response = HttpClientBuilder.create().setDefaultHeaders(Arrays.asList(new BasicHeader("Authorization", token))).build().execute(request);
        String body = response.toString();
        logger.info(body);
        System.out.println(body);
    }
}


