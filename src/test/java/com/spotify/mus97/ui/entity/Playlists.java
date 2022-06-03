package com.spotify.mus97.ui.entity;

public class Playlists {

    private String playlistName;

    public Playlists(String playlistName) {
        this.playlistName = playlistName;
    }

    public String getPlaylistName() {
        return playlistName;
    }

    @Override
    public String toString() {
        return ("\nPlaylist: " + playlistName) ;
    }
}