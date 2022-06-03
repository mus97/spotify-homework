package com.spotify.mus97.ui.tests;

import com.spotify.mus97.ui.steps.CheckLoginStep;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends AbstractTest{
    @Test
    public void loginTest(){
        String username = "CustomUser";
        Assert.assertTrue(new CheckLoginStep().checkUsername(username));
    }

}
