package com.example.gilmoregameflixproject.controller;

import com.example.gilmoregameflixproject.model.User;
import com.example.gilmoregameflixproject.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private UserService userService;

    // Registration endpoint
    @PostMapping("/register")
    public ResponseEntity<Map<String, String>> registerUser(@ModelAttribute User user) {
        String response = userService.registerUser(user);

        Map<String, String> responseMap = new HashMap<>();
        responseMap.put("message", response);

        if (response.equals("User registered successfully")) {
            return ResponseEntity.ok(responseMap);
        } else {
            return ResponseEntity.badRequest().body(responseMap);
        }
    }

    // Login endpoint
    @PostMapping("/login")
    public ResponseEntity<Map<String, String>> loginUser(@ModelAttribute User user) {
        String result = userService.login(user.getUsername(), user.getPassword());

        Map<String, String> responseMap = new HashMap<>();
        responseMap.put("message", result);

        if (result.equals("Login successful")) {
            return ResponseEntity.ok(responseMap);
        } else {
            return ResponseEntity.status(401).body(responseMap);
        }
    }

}
