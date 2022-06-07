package com.spotify.mus97.ui.pages;

import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class PlaylistPage extends AbstractPage {

    @FindBy(xpath = "//h1")
    protected WebElement nameOfCreatedPlaylist;
    @FindBy(xpath = "//*[@data-testid='rootlist-item']")
    protected List<WebElement> usersPlaylists;
    @FindBy(xpath = "//li[5]/button")
    protected WebElement deletePlaylistButton;
    @FindBy(xpath = "//div[@class='ButtonInner-sc-14ud5tc-0 hKccLC encore-bright-accent-set']/parent::button")
    protected WebElement surelyDeletePlaylistButton;

    String nameOfPlaylist;

    public String getPlaylistName() {
        try{
            nameOfPlaylist = waitForVisibilityOfElement(nameOfCreatedPlaylist).getText();
            logger.info("You just created " + nameOfPlaylist);

        }
        catch (TimeoutException e){
            logger.error(e.getMessage());
        }
        return nameOfPlaylist;
    }

}
