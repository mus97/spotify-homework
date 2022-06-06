package com.spotify.mus97.ui.utils;

import com.spotify.mus97.ui.entity.User;

public class UserCreator {

    public static final String USER_NAME = "31mwtfrzpnqqccvvdz63p575e32m";
    public static final String USER_PASSWORD = "huggy wuggy";
    public static final String USER_NAME_INVALID = "31me32m";
    public static final String USER_PASSWORD_INVALID = "huuggy";

    public static User createValidUser() {
        return new User(USER_NAME, USER_PASSWORD);
    }
    public static User createInvalidUser() {
        return new User(USER_NAME_INVALID, USER_PASSWORD_INVALID);
    }
}
