package com.spotify.mus97.ui.pages;

import com.spotify.mus97.ui.entity.User;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends AbstractPage {
    @FindBy(id = "login-username")
    private WebElement inputUserName;
    @FindBy(id = "login-password")
    private WebElement inputPassword;
    @FindBy(id = "login-button")
    private WebElement loginButton;


    public AuthorizedHomepage authorize(User user) {

        waitForVisibilityOfElement(inputUserName).sendKeys(user.getUsername());
        inputPassword.sendKeys(user.getPassword());
        loginButton.click();
         return new AuthorizedHomepage();
    }
}
