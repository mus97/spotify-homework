package com.spotify.mus97.ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class AuthorizedHomepage extends AbstractPage {

    @FindBy(xpath = "//*[@href='/search']")
    protected WebElement searchButton;
    @FindBy(xpath = "//form[@role='search']/input")
    protected WebElement searchInput;
    @FindBy(xpath = "//button[@data-testid='create-playlist-button']")
    protected WebElement createPlaylistButton;
    @FindBy (xpath = "//button[@data-testid='user-widget-link']")
    protected WebElement userButton;
    @FindBy (xpath = "//*[@data-testid='rootlist-item']")
    protected List<WebElement> usersPlaylists;

    public AuthorizedHomepage clickSearchButton (){
        waitForVisibilityOfElement(searchButton).click();
        return this;
    }
    public SearchResultPage writeSearchQuery(String searchQuery) {
        waitForVisibilityOfElement(searchInput).clear();
        searchInput.sendKeys(searchQuery, Keys.ENTER);
        return new SearchResultPage();
    }
    public PlaylistPage createPlaylist(){
        waitForVisibilityOfElement(createPlaylistButton).click();
        return new PlaylistPage();
    }

}
