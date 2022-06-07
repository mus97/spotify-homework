package com.spotify.mus97.ui.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SpotifyHomepage extends AbstractPage {

    private final String HOMEPAGE_URL = "https://open.spotify.com/";
    @FindBy(xpath = "//button[@data-testid='login-button']")
    private WebElement loginButton;

    public SpotifyHomepage openPage() {
        driver.get(HOMEPAGE_URL);
        return this;
    }

    public LoginPage clickLoginButton() {
        waitForVisibilityOfElement(loginButton).click();
        return new LoginPage();
    }

}
