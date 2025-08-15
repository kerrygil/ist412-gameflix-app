package com.example.gilmoregameflixproject.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.security.Principal;
import java.util.List;

@Controller
@RequestMapping("/library")
public class LibraryController {

    @PostMapping
    public String addLibrary(@RequestParam("gameIds")List<Long> gameIds, Principal principal) {

        return "redirect:/games?success=Games added to your library";
    }
}
