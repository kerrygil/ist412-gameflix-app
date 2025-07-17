package com.example.gilmoregameflixproject.service;

import com.example.gilmoregameflixproject.model.User;

public interface UserService {

    String registerUser(User user);
    String login(String username, String password);

}
