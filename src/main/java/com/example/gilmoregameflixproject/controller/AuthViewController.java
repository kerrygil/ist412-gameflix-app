package com.example.gilmoregameflixproject.controller;

import com.example.gilmoregameflixproject.model.User;
import com.example.gilmoregameflixproject.service.UserService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

@Controller
@RequestMapping("/view")
public class AuthViewController {

    @Autowired
    private UserService userService;

    @PostMapping("register")
    public String registerUser(User user) {
        String response = userService.registerUser(user);

        if (response.equals("User registered successfully")) {
            return "redirect:/login?success=" + URLEncoder.encode(response,StandardCharsets.UTF_8);
        }
        return "redirect:/register?error=" + URLEncoder.encode(response, StandardCharsets.UTF_8);
    }

    @PostMapping("login")
    public String login(User user, HttpServletRequest request) {
        String result = userService.login(user.getUsername(), user.getPassword());

        if (result.equals("Login successful")) {
            UsernamePasswordAuthenticationToken authtoken =
                    new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword());
            SecurityContextHolder.getContext().setAuthentication(authtoken);

            request.getSession(true);

            return "redirect:/games?success=" + URLEncoder.encode(result,StandardCharsets.UTF_8);
        }
        return "redirect:/login?error=" + URLEncoder.encode(result, StandardCharsets.UTF_8);
    }
}
