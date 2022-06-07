package com.spotify.mus97.api.test;

import org.apache.http.HttpHeaders;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.is;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;


public class UserInformationTests extends AbstractTest {

    @Test(priority = 0)
    public void testGetUserInfo() {
        String url = "https://api.spotify.com/v1/me";
        String key = "display_name";
        String value = "CustomUser";

        client.sendGet(url);
        client.getBody();

        assertEquals(client.getStatusCode(), 200);
        assertTrue(client.getListBodyValuesByKey(key).contains(value));
    }

    @DataProvider(name = "token")
    public Object[] tokenProvider() {
        return new Object[]{"Bearer BQD3_6MqhHvQtE0R3p3ExG2Ilgz_vWX9kufxFzFrnedTF0fg9o0TLy4brLAPVnXM37Kg0JB2_7mnQgMafOTtJDY8J2qhUmN8oXioT-Sys2lYmqYM1sQWhX9D5xO-VA3vU1W5xkNIqmKF6P0xEGfwmirDKNHXHmS5FIOviSI4Nfb86KeCjKgc0wfIOPqMG9-tmtVp2hT7vtX413vMiCxElCi5SOD5KsmpcXEVu2Xb4LK9ezA0qx2iUxXBZHfYruVR5fXU2RGcR0G1p0Gg01dVMHGoCmjdaIxOWT8z5DalNliEhHxCYHeT"};
    }

    @Test(dataProvider = "token", priority = 0)
    public void testGetUserInfoRestAssured(String token) {

        given().header(HttpHeaders.AUTHORIZATION, token)
                .when().get("https://api.spotify.com/v1/me")
                .then().assertThat().statusCode(200)
                .and().body("display_name", is("CustomUser"));
    }

    @Test(priority = 0)
    public void testGetRecommendations() {
        String url = "https://api.spotify.com/v1/recommendations/available-genre-seeds";
        String key = "genres";

        client.sendGet(url);

        assertEquals(client.getStatusCode(), 200);
        assertTrue(client.getBody().contains(key));
    }
}
