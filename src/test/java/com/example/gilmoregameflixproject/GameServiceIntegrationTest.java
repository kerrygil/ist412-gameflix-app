package com.example.gilmoregameflixproject;

import com.example.gilmoregameflixproject.model.Game;
import com.example.gilmoregameflixproject.service.GameService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.util.List;

@SpringBootTest
@ActiveProfiles("test")
public class GameServiceIntegrationTest {

    @Autowired
    private GameService gameService;

    @Test
    void addGame_ShouldSaveSuccessfully() {
        Game newGame = new Game("The Legend of Zelda", "Adventure", "Classic fantasy exploration", 59.99);
        Game savedGame = gameService.addGame(newGame);

        Assertions.assertNotNull(savedGame.getId());
        Assertions.assertEquals("The Legend of Zelda", savedGame.getTitle());
    }

    @Test
    void getAllGames_ShouldReturnList() {
        List<Game> games = gameService.getAllGames();
        Assertions.assertNotNull(games);
    }

    @Test
    void updateGame_ShouldChangeDetails() {
        Game newGame = new Game("Mario Kart", "Racing", "Fun multiplayer racing game", 49.99);
        Game savedGame = gameService.addGame(newGame);

        savedGame.setDescription("New Description");
        Game updatedGame = gameService.updateGame(savedGame.getId(), savedGame);

        Assertions.assertEquals("New Description", updatedGame.getDescription());
    }
}