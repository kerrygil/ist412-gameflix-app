package com.example.gilmoregameflixproject;

import com.example.gilmoregameflixproject.model.User;
import com.example.gilmoregameflixproject.service.UserService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.util.List;

@SpringBootTest
@ActiveProfiles("test")
public class UserServiceIntegrationTest {

    @Autowired
    private UserService userService;

    @Test
    void getAllUsers_ShouldReturnList() {
        List<User> allUsers = userService.getAllUsers();
        Assertions.assertFalse(allUsers.isEmpty());
    }

    @Test
    void registerUser_ShouldStoreUser() {
        User user = new User();
        user.setUsername("test");
        user.setPassword("test");

        String savedUser = userService.registerUser(user);
        Assertions.assertEquals("test", user.getUsername());
    }

    @Test
    void loginUser_ShouldReturnUser_WhenCredentialsValid() {
        String result = userService.login("test", "test");
        Assertions.assertEquals("Login successful", result);
    }
}
