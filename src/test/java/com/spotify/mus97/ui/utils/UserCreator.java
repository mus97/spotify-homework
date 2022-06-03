package com.spotify.mus97.ui.utils;

import com.spotify.mus97.ui.entity.User;

public class UserCreator {

    public static final String USER_NAME = "31mwtfrzpnqqccvvdz63p575e32m";
    public static final String USER_PASSWORD = "huggy wuggy";

    public static User createUser() {
        return new User(USER_NAME, USER_PASSWORD);
    }
}
