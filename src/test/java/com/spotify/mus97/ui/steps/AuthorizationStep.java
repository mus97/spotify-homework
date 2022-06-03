package com.spotify.mus97.ui.steps;

import com.spotify.mus97.ui.entity.User;
import com.spotify.mus97.ui.pages.SpotifyHomepage;
import com.spotify.mus97.ui.utils.UserCreator;
import org.openqa.selenium.WebDriver;

public class AuthorizationStep {

    public static void logIn() {
        User user = UserCreator.createUser();
        new SpotifyHomepage().openPage()
                .clickLoginButton().authorize(user);
    }
}
