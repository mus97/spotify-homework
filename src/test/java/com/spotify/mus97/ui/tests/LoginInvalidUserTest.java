package com.spotify.mus97.ui.tests;

import com.spotify.mus97.ui.entity.User;
import com.spotify.mus97.ui.pages.SpotifyHomepage;
import com.spotify.mus97.ui.utils.UserCreator;
import org.testng.Assert;
import org.testng.annotations.Test;

import static com.spotify.mus97.ui.driver.DriverSingleton.closeDriver;

public class LoginInvalidUserTest {
    @Test
    public void loginTestInvalid(){
        User user = UserCreator.createInvalidUser();
        Assert.assertEquals((new SpotifyHomepage().openPage()
                .clickLoginButton().authorize(user).incorrectLogin()), "Неправильное имя пользователя или пароль.");
        closeDriver();

    }
}
