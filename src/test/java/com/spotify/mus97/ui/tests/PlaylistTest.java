package com.spotify.mus97.ui.tests;

import com.spotify.mus97.ui.pages.AuthorizedHomepage;
import com.spotify.mus97.ui.steps.CheckUsersPlaylistsStep;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PlaylistTest extends AbstractTest{
    @Test (description = "testing a presence of just created playlist in the list of your playlists")
    //sometimes fails because of long loading of page of just created playlist
    public void checkPresenceOfNewPlaylist() {
        String getNameOfJustCreatedPlaylist =new AuthorizedHomepage().createPlaylist().getPlaylistName();
        Assert.assertTrue(new CheckUsersPlaylistsStep().checkCreatedPlInAllPl(getNameOfJustCreatedPlaylist));
    }
    @Test (dependsOnMethods = "checkPresenceOfNewPlaylist")
    public void deleteAllUsersPlaylists() {
        CheckUsersPlaylistsStep checkUsersPlaylistsStep = new CheckUsersPlaylistsStep().deleteAllPlaylists();
        Assert.assertTrue(checkUsersPlaylistsStep.checkAllPlaylistsAreDeleted());
    }
}
