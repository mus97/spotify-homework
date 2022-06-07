package com.spotify.mus97.api.test;

import org.apache.http.entity.StringEntity;
import org.testng.annotations.Test;

import java.io.UnsupportedEncodingException;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class PlaylistTests extends AbstractTest {

    @Test(priority = 0)
    public void testCreateNewPlaylist() {
        String url = "https://api.spotify.com/v1/users/31mwtfrzpnqqccvvdz63p575e32m/playlists";
        StringEntity params;
        String key = "name";
        String value = "One more playlist";

        try {
            params = new StringEntity("{\n" +
                    "  \"name\": \""+value+"\",\n" +
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

    @Test(priority = 0)
    public void testFollowPlaylist() {
        String urlToPut = "https://api.spotify.com/v1/playlists/37i9dQZF1DX1tuUiirhaT3/followers";
        String urlToGet = "https://api.spotify.com/v1/playlists/37i9dQZF1DX1tuUiirhaT3/followers/contains?ids=31mwtfrzpnqqccvvdz63p575e32m";

        client.sendPut(urlToPut);
        assertEquals(client.getStatusCode(), 200);

        client.sendGet(urlToGet);
        client.getBody();
        assertTrue(client.getBody().contains("true"));
    }

    @Test(priority = 0)
    public void testUnfollowPlaylist() {
        String urlToDelete = "https://api.spotify.com/v1/playlists/37i9dQZF1DX1tuUiirhaT3/followers";
        String urlToGet = "https://api.spotify.com/v1/playlists/37i9dQZF1DX1tuUiirhaT3/followers/contains?ids=31mwtfrzpnqqccvvdz63p575e32m";

        client.sendDelete(urlToDelete);
        assertEquals(client.getStatusCode(), 200);

        client.sendGet(urlToGet);
        client.getBody();
        assertTrue(client.getBody().contains("false"));
    }
}
