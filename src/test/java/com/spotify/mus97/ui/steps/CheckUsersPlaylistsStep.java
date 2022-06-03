package com.spotify.mus97.ui.steps;

import com.spotify.mus97.ui.entity.Playlists;
import com.spotify.mus97.ui.pages.AuthorizedHomepage;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class CheckUsersPlaylistsStep extends AuthorizedHomepage {
    List<Playlists> playlistNames;

    public List<Playlists> checkPlaylist() {
        playlistNames = new ArrayList<>();
        waitForVisibilityOfElements(usersPlaylists);
        logger.info("Users playlist:");
        for (WebElement userPlaylistName : usersPlaylists) {
            String playlistName =  userPlaylistName.getText();
            playlistNames.add(new Playlists(playlistName));
        }
        logger.info(playlistNames);
        return playlistNames;
    }
}
