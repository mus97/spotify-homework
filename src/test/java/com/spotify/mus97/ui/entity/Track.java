package com.spotify.mus97.ui.entity;

public class Track {
    private String artist;
    private String track;
    private String message;


    public Track(String track, String artist) {
        this.artist = artist;
        this.track = track;
    }

    public String getArtist() {
        return artist;
    }

    public String getTrack() {
        return track;
    }


    @Override
    public String toString() {
        return ("\nartist: " + artist + " " +
                ", track: " + track + "") ;
    }
}
