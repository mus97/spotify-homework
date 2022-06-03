package com.spotify.mus97.ui.tests;

import com.spotify.mus97.ui.driver.DriverSingleton;
import com.spotify.mus97.ui.steps.AuthorizationStep;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

abstract class AbstractTest {

    @BeforeTest
    public void logIn() {
        AuthorizationStep.logIn();
    }

    @AfterTest
    public void tearDown() {
        DriverSingleton.closeDriver();
    }
}
