package com.example.gilmoregameflixproject.service;

import com.example.gilmoregameflixproject.model.User;
import com.example.gilmoregameflixproject.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    private final BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    // Check if username exists, hashes password, and stores in repository
    @Override
    public String registerUser(User user) {
        if (userRepository.existsByUsername(user.getUsername())) {
            return "User already exists";
        }

        String encodedPassword = passwordEncoder.encode(user.getPassword());
        user.setPassword(encodedPassword);
        userRepository.save(user);

        return "User registered successfully";
    }

    // Retrieves username and checks if entered password matches repository
    @Override
    public String login(String username, String password) {
        Optional<User> optionalUser = userRepository.findByUsername(username);

        if (optionalUser.isPresent()) {
            User user = optionalUser.get();
            if (passwordEncoder.matches(password, user.getPassword())) {
                return "Login successful";
            }
        }

        return "Invalid username or password";
    }

}
