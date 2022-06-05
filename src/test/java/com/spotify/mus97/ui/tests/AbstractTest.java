package com.spotify.mus97.ui.tests;

import com.spotify.mus97.ui.driver.DriverSingleton;
import com.spotify.mus97.ui.steps.AuthorizationStep;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

abstract class AbstractTest {

    @BeforeClass
    public void logIn() {
        AuthorizationStep.logIn();
    }

    @AfterClass
    public void tearDown() {
        DriverSingleton.closeDriver();
    }
}
