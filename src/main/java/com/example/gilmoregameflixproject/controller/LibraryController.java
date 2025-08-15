package com.example.gilmoregameflixproject.controller;

import com.example.gilmoregameflixproject.model.Game;
import com.example.gilmoregameflixproject.model.User;
import com.example.gilmoregameflixproject.repository.UserRepository;
import com.example.gilmoregameflixproject.service.LibraryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@Controller
@RequestMapping("/library")
public class LibraryController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private LibraryService libraryService;

    /**
     * View user's game library
     */
    @GetMapping
    public String viewLibrary(Model model, Principal principal) {
        User user = userRepository.findByUsername(principal.getName())
                .orElseThrow(() -> new RuntimeException("User not found"));

        List<Game> libraryGames = libraryService.getLibraryGames(user);
        model.addAttribute("libraryGames", libraryGames);
        return "library";
    }

    /**
     * Add games to library
     */
    @PostMapping("/add")
    public String addLibrary(@RequestParam("gameIds") List<Long> gameIds, Principal principal) {
        User user = userRepository.findByUsername(principal.getName())
                .orElseThrow(() -> new RuntimeException("User not found"));

        libraryService.addGamesToLibrary(user, gameIds);
        return "redirect:/library";
    }

    /**
     * Remove games from library
     */
    @PostMapping("/remove")
    public String removeFromLibrary(@RequestParam("gameIds") List<Long> gameIds, Principal principal) {
        User user = userRepository.findByUsername(principal.getName())
                .orElseThrow(() -> new RuntimeException("User not found"));

        libraryService.removeGamesFromLibrary(user, gameIds);
        return "redirect:/library";
    }
}


