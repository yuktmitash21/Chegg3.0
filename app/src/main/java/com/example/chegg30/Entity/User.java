package com.example.chegg30.Entity;

import android.util.Log;

public class User {
    private String username;
    private String password;
    private static int userNumber;

    private static final String TAG = "User.java";

    public User(String username, String password) {
        this.username = username;
        this.password = password;
        userNumber++;
        Log.d(TAG, "usernumber: " + userNumber);

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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User)) return false;
        User user = (User) o;
        return getUsername().equals(user.getUsername()) &&
                getPassword().equals(user.getPassword());
    }

    @Override
    public int hashCode() {
        int a = 15;
        a = 32 * a + username.hashCode();
        a = 32 * a + password.hashCode();
        return a;

    }

    public int getId() {
        return userNumber;
    }
}
