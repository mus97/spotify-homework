package com.spotify.mus97.ui.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class SearchResultPage extends AbstractPage{
    @FindBy(xpath = "//*[@data-testid='tracklist-row']")
    protected List<WebElement> artistTracks;
}
