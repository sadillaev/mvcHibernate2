package com.peaksoft.crud.dao;

import com.peaksoft.crud.model.User;

import java.util.List;

public interface UserDao {

    void addUser(User user);

    List<User> getAllUsers();

    void updateUser(User user);

    void deleteUser(User user);
}
