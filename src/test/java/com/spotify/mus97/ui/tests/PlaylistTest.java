package com.spotify.mus97.ui.tests;

import com.spotify.mus97.ui.pages.AuthorizedHomepage;
import com.spotify.mus97.ui.steps.AddTracksToPlaylistStep;
import org.testng.annotations.Test;

public class PlaylistTest extends AbstractTest{
    @Test
    public void createNewPlaylist() throws InterruptedException {
        AddTracksToPlaylistStep addTracksToPlaylist =new AuthorizedHomepage().createPlaylist().closeSearch().chooseRecommendedTracks();
        Thread.sleep(3000);
    }
    @Test
    public void
}
