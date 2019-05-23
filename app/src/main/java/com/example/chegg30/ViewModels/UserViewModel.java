package com.example.chegg30.ViewModels;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.support.annotation.NonNull;

import com.example.chegg30.Entity.User;
import com.example.chegg30.Model.Model;
import com.example.chegg30.Model.UserInteractor;

import java.util.ArrayList;

public class UserViewModel extends AndroidViewModel {
    private ArrayList<User> users;
    private UserInteractor userInteractor;

    public UserViewModel(@NonNull Application application) {
        super(application);
        userInteractor = Model.getInstanceOfModel().getUserInteractor();
        users = userInteractor.getAllUsers();
    }

    public void registerUser(String username, String password) {
        User user = new User(username, password);
        userInteractor.registerUser(user);
        users = userInteractor.getAllUsers();
    }

    /**
     *
     * @param username username of user
     * @param password password of user
     * @return -1 if invalid user
     * @return user id if valid user
     */

    public int validUser(String username, String password) {
        User user = new User(username, password);
        if (userInteractor.validUser(user)) {
            for (User userObj : users) {
                if (userObj.getUsername().equals(username)
                        && userObj.getPassword().equals(password)) {
                    return userObj.hashCode();
                }
            }

        }

        return -1;
    }

    public String errorMessage(String username, String password) {
        User user = new User(username, password);
        return userInteractor.getErrorMessage(user);
    }

    public User findUserbyId(int id) {
        for (User user: users) {
            if (user.hashCode() == id) {
                return user;
            }
        }
        return null;
    }

    public ArrayList<User> getAllUsers(){return users;}
}
