package com.hafidzmrizky.mybio.Core;

import com.hafidzmrizky.mybio.Model.UserModel;

import java.util.ArrayList;
import java.util.Collection;

public class User extends UserModel {
    private static User instance;
    private Collection<UserModel> users;

    public static User getInstance() {
        if (instance == null) {
            instance = new User();
        }
        return instance;
    }

    public User() {
        users = new ArrayList<>();
    }

    public void addUser(UserModel userModel) {
        this.users.add(userModel);
    }

    public Collection<UserModel> getUsers() {
        return users;
    }

    public Collection<UserModel> getUser() {
        Collection<UserModel> matchingUsers = new ArrayList<>();

        for (UserModel user : users) {
            if (user.getNama().equals(getNama())) {
                matchingUsers.add(user);
            }
        }

        return matchingUsers;
    }

    public Collection<UserModel> getUserById(int id) {
        Collection<UserModel> matchingUsers = new ArrayList<>();

        for (UserModel user : users) {
            if (user.getId() == id) {
                matchingUsers.add(user);
            }
        }

        return matchingUsers;
    }

    public void clearData() {
        users.clear();
    }


}
