package com.spotify.mus97.ui.entity;

public class Playlists {

    private String plName;

    public Playlists(String playlistName) {
        this.plName = playlistName;
    }

    public String getPlName() {
        return plName;
    }

    @Override
    public String toString() {
        return ("\nPlaylist: " + plName) ;
    }
}