package com.spotify.mus97.ui.steps;

import com.spotify.mus97.ui.pages.AuthorizedHomepage;
import org.openqa.selenium.By;

public class CheckLoginStep extends AuthorizedHomepage {
    String userButtonContent;

    public String checkUserButton() {
        userButtonContent = waitForVisibilityOfElement(userButton).findElement(By.xpath("./span")).getText();
        logger.info("Username is " + userButtonContent);
        return userButtonContent;

    }

    public boolean checkUsername(String username) {
        if (userButtonContent == null) {
            userButtonContent = checkUserButton();
        }
        return userButtonContent.contains(username);
    }
}
