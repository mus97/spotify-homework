package com.spotify.mus97.api.test;

import org.apache.http.HttpHeaders;
import org.apache.http.entity.StringEntity;
import org.apache.http.message.BasicHeader;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Test;

import java.io.*;
import java.util.Arrays;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;
import static org.hamcrest.Matchers.is;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;


public class GetArticles extends AbstractTest {

    @Test
    public void testGetUserInfo() {
        String url = "https://api.spotify.com/v1/me";
        String key = "display_name";
        String value = "Мария Кучинская";
        client.sendGet(url);
        client.getBody();
        assertEquals(client.getStatusCode(), 200);
        assertTrue(client.getListBodyValuesByKey(key).contains(value));
    }
    @Test
    public void testGetUserInfoRestAssured() {
        String token = "Bearer BQAje98myA9LOf3-HZobWQOD27jYjMRMYvLnOKXH_aHEfhdyuOkIgzjnlmkGfS97QdwTJ5Op37KgfL_4LGDvJv1LzGgB8uYmO6lQQhRDyNYx-NNuwnoTD0NhpfwWm9grf9mNFqoQ0Oza9Lk2cp8tiA4yx2xXLFhkWDcW-Igzxw3JfEed-qNlgJnRsL6WYK162tsrKSEeAG146RbJanpuMCeFBdELa_V7fuURLoOc33B3Iduo3bLT2jSpTOZZAY33tmPMgb3Rgl7zhsCFEwgUszeNIpLxUFsMJ473e2cXnaQAQn1kRomm";
        given().header(HttpHeaders.AUTHORIZATION,token)
        .when().get("https://api.spotify.com/v1/me").
                then().assertThat().statusCode(200).
                and().body("display_name", is("Мария Кучинская"));
    }
    @Test
    public void testGetRecommendations() {
        String url = "https://api.spotify.com/v1/recommendations/available-genre-seeds";
        String key = "genres";
        client.sendGet(url);

        assertEquals(client.getStatusCode(), 200);
        assertTrue(client.getBody().contains(key));
    }

    @Test
    public void testCreateNewPlaylist() {
        String url = "https://api.spotify.com/v1/users/31k4mqz2xcjhifwvxm7jxrv7qsnm/playlists";
        StringEntity params;
        String key = "name";
        String value = "New Playlist";
        try {
            params = new StringEntity("{\n" +
                    "  \"name\": \"New Playlist\",\n" +
                    "  \"description\": \"New playlist description\",\n" +
                    "  \"public\": false\n" +
                    "}");
            client.sendPost(url, params);
            client.getBody();
            assertEquals(client.getStatusCode(), 201);
            assertTrue(client.getListBodyValuesByKey(key).contains(value));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }
    @Test
    public void testFollowPlaylist() {
        String urlToPut = "https://api.spotify.com/v1/playlists/37i9dQZF1DX1tuUiirhaT3/followers";
        String urlToGet = "https://api.spotify.com/v1/playlists/37i9dQZF1DX1tuUiirhaT3/followers/contains?ids=31k4mqz2xcjhifwvxm7jxrv7qsnm";
        client.sendPut(urlToPut);
        assertEquals(client.getStatusCode(), 200);
        client.sendGet(urlToGet);
        client.getBody();
        assertTrue(client.getBody().contains("true"));
    }

    @Test
    public void testUnfollowPlaylist() {
        String urlToDelete = "https://api.spotify.com/v1/playlists/37i9dQZF1DX1tuUiirhaT3/followers";
        String urlToGet = "https://api.spotify.com/v1/playlists/37i9dQZF1DX1tuUiirhaT3/followers/contains?ids=31k4mqz2xcjhifwvxm7jxrv7qsnm";
        client.sendDelete(urlToDelete);
        assertEquals(client.getStatusCode(), 200);
        client.sendGet(urlToGet);
        client.getBody();
        assertTrue(client.getBody().contains("false"));
    }



}