package com.spotify.mus97.ui.steps;

import com.spotify.mus97.ui.pages.PlaylistPage;
import org.openqa.selenium.WebElement;

public class AddTracksToPlaylistStep extends PlaylistPage {

    public AddTracksToPlaylistStep chooseRecommendedTracks(){
        for (WebElement addTrackButton : addTrackButtons) {
            waitForVisibilityOfElement(addTrackButton).click();
        }
        return this;
    }
}
