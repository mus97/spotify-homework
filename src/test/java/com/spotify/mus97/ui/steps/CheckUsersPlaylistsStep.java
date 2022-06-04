package com.spotify.mus97.ui.steps;

import com.spotify.mus97.ui.entity.Playlists;
import com.spotify.mus97.ui.pages.PlaylistPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class CheckUsersPlaylistsStep extends PlaylistPage {
    List<Playlists> playlistNames;

    public List<Playlists> getPlaylistNames() {
        playlistNames = new ArrayList<>();
        waitForVisibilityOfElements(usersPlaylists);
        logger.info("Users playlists:");
        for (WebElement userPlaylistName : usersPlaylists) {
            String playlistName = waitForVisibilityOfElement(userPlaylistName).getText();
            playlistNames.add(new Playlists(playlistName));
        }
        logger.info(playlistNames);
        return playlistNames;
    }

    public boolean checkCreatedPlInAllPl(String playlist) {
        if (playlistNames == null) {
            playlistNames = getPlaylistNames();
        }
        return playlistNames.stream().anyMatch(s -> s.getPlName().contains(playlist));
    }

    Actions actions = new Actions(driver);
    public CheckUsersPlaylistsStep deleteAllPlaylists(){
        waitForVisibilityOfElements(usersPlaylists);
        int i = usersPlaylists.size();
        for (WebElement userPlaylistName : usersPlaylists) {
            actions.contextClick(waitForElementToBeClickable(userPlaylistName)).perform();
            actions.click(waitForElementToBeClickable(deletePlaylistButton)).perform();
            actions.click(waitForVisibilityOfElement(surelyDeletePlaylistButton)).perform();
            i-=1;
            new WebDriverWait(driver, Duration.ofSeconds(WAIT_TIMEOUT_SECONDS))
                    .until(ExpectedConditions.numberOfElementsToBe(By.xpath("//*[@data-testid='rootlist-item']"),(i)));
        }
        return this;
    }
    public boolean checkAllPlaylistsAreDeleted(){
        boolean noPlaylists = usersPlaylists.isEmpty();
        logger.info("You deleted all playlists");
        return noPlaylists;
    }
}
