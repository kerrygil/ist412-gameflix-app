package com.example.gilmoregameflixproject.service;

import com.example.gilmoregameflixproject.model.User;

import java.util.List;

public interface UserService {

    String registerUser(User user);
    String login(String username, String password);
    List<User> getAllUsers();
}
