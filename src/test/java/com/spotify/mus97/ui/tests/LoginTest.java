package com.spotify.mus97.ui.tests;

import com.spotify.mus97.ui.steps.CheckLoginStep;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends AbstractTest{
    @Test (description = "Testing of logging in with valid assertion")
    public void loginTestValid(){
        String username = "CustomUser";
        Assert.assertTrue(new CheckLoginStep().checkUsername(username));
    }
    @Test (description = "Testing of logging in with invalid assertion")
    public void loginTestInvalid(){
        String username = "AlterEgo";
        Assert.assertTrue(new CheckLoginStep().checkUsername(username));
    }

}
