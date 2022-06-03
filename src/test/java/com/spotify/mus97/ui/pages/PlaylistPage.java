package com.spotify.mus97.ui.pages;

import com.spotify.mus97.ui.steps.AddTracksToPlaylistStep;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class PlaylistPage extends AbstractPage{
    @FindBy (className = "FC40AOSbVM9LXjVi7bjO")
    private WebElement closeSearchButton;
    @FindBy (xpath = "//button[@class='Button-y0gtbx-0 jjUWAm']")
    protected List<WebElement> addTrackButtons;

    public AddTracksToPlaylistStep closeSearch(){
        waitForVisibilityOfElement(closeSearchButton).click();
        return new AddTracksToPlaylistStep();
    }

}
