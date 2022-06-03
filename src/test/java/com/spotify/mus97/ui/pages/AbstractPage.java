package com.spotify.mus97.ui.pages;

import com.spotify.mus97.ui.driver.DriverSingleton;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class AbstractPage {
    protected static final Logger logger = LogManager.getLogger();
    protected WebDriver driver;
    public final int WAIT_TIMEOUT_SECONDS = 10;

    protected AbstractPage() {
        driver = DriverSingleton.getDriver();
        PageFactory.initElements(driver, this);
    }

    protected WebElement waitForVisibilityOfElement(WebElement webElement) {
        return new WebDriverWait(driver, Duration.ofSeconds(WAIT_TIMEOUT_SECONDS))
                .until(ExpectedConditions.visibilityOf(webElement));
    }
    protected List<WebElement> waitForVisibilityOfElements(List<WebElement> webElement) {
        return new WebDriverWait(driver, Duration.ofSeconds(WAIT_TIMEOUT_SECONDS))
                .until(ExpectedConditions.visibilityOfAllElements(webElement));
    }
}
