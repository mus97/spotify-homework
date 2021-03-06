package com.spotify.mus97.ui.tests;

import com.spotify.mus97.ui.steps.CheckLoginStep;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginValidUserTest extends AbstractTest {

    @Test(description = "Testing of logging in with valid assertion", priority = 2)
    public void loginTestValid() {
        String username = "CustomUser";
        Assert.assertTrue(new CheckLoginStep().checkUsername(username));
    }

}
