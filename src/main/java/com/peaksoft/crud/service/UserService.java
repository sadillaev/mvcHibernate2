package com.peaksoft.crud.service;

import com.peaksoft.crud.model.User;

import java.util.List;

public interface UserService {

    void addUser(User user);

    List<User> getAllUsers();

    void updateUser(User user);

    void deleteUser(User user);
}
