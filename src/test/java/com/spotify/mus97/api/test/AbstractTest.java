package com.spotify.mus97.api.test;

import com.spotify.mus97.api.client.Client;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class AbstractTest {
    Client client;

    @BeforeClass
    public void getClient() {
        client = new Client();
    }

    @AfterClass
    public void tearDownClient() {
        client.closeClient();
    }
}