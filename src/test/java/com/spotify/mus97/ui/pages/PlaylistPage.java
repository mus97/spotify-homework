package com.spotify.mus97.ui.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class PlaylistPage extends AbstractPage{

    @FindBy (xpath = "//h1")
    protected WebElement nameOfCreatedPlaylist;
    @FindBy (xpath = "//*[@data-testid='rootlist-item']")
    protected List<WebElement> usersPlaylists;
    @FindBy (xpath = "//*[text()[contains (.,'Удалить')]]/parent::button")
    protected WebElement deletePlaylistButton;
    @FindBy (xpath = "//div[text()='УДАЛИТЬ']/parent::button")
    protected WebElement surelyDeletePlaylistButton;

    String nameOfPlaylist;

    public String getPlaylistName(){
        nameOfPlaylist = waitForVisibilityOfElement(nameOfCreatedPlaylist).getText();
        logger.info("You just created " + nameOfPlaylist);
        return nameOfPlaylist;
    }

}
