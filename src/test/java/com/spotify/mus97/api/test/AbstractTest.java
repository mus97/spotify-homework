package com.spotify.mus97.api.test;

import com.spotify.mus97.api.client.Client;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

public class AbstractTest {
    Client client;

    @BeforeMethod
    public void getClient() {
        client = new Client();
    }

    @AfterMethod
    public void tearDownClient() {
        client.closeClient();
    }
}