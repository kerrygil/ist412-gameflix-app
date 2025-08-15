package com.example.gilmoregameflixproject.controller;

import com.example.gilmoregameflixproject.model.Game;
import com.example.gilmoregameflixproject.service.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ui.Model;

import java.util.List;

@Controller
public class GameViewController {

    @Autowired
    private GameService gameService;

    @GetMapping("/games")
    public String gamesPage(Model model) {
        List<Game> games = gameService.getAllGames();
        model.addAttribute("games", games);
        return "games";
    }
}
