package com.example.gilmoregameflixproject.service;

import com.example.gilmoregameflixproject.model.Game;
import com.example.gilmoregameflixproject.model.User;

import java.util.List;

public interface LibraryService {
    List<Game> getLibraryGames(User user);
    void addGamesToLibrary(User user, List<Long> gameIds);
    void removeGamesFromLibrary(User user, List<Long> gameIds);
}

