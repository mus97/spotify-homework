package com.spotify.mus97.ui.entity;

public class User {
    private String username;
    private String password;

    public User(String username, String password) {
        this.username = username; //31mwtfrzpnqqccvvdz63p575e32m
        this.password = password; //huggy wuggy
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
