package com.example.gilmoregameflixproject.service;

import com.example.gilmoregameflixproject.model.Game;
import java.util.List;

public interface GameService {
    List<Game> getAllGames();

    Game getGameById(Long id);

    Game addGame(Game game);

    Game updateGame(Long id, Game game);

    void deleteGame(Long id);
}
