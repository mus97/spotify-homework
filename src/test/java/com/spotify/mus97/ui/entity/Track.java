package com.spotify.mus97.ui.entity;

public class Track {
    private String artist;
    private String track;

    public Track(String track, String artist) {
        this.artist = artist;
        this.track = track;
    }

    public String getArtist() {
        return artist;
    }

    @Override
    public String toString() {
        return ("\nartist: " + artist + " " +
                ", track: " + track + "") ;
    }
}
