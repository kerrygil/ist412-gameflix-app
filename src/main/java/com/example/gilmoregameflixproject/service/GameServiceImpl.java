package com.example.gilmoregameflixproject.service;

import com.example.gilmoregameflixproject.model.Game;
import com.example.gilmoregameflixproject.repository.GameRepository;
import com.example.gilmoregameflixproject.service.GameService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GameServiceImpl implements GameService {

    private final GameRepository gameRepository;

    public GameServiceImpl(GameRepository gameRepository) {
        this.gameRepository = gameRepository;
    }

    @Override
    public List<Game> getAllGames() {
        return gameRepository.findAll();
    }

    @Override
    public Game getGameById(Long id) {
        return gameRepository.findById(id).orElse(null);
    }

    @Override
    public Game addGame(Game game) {
        return gameRepository.save(game);
    }

    @Override
    public Game updateGame(Long id, Game game) {
        Optional<Game> existingGame = gameRepository.findById(id);
        if (existingGame.isPresent()) {
            Game updatedGame = existingGame.get();
            updatedGame.setTitle(game.getTitle());
            updatedGame.setGenre(game.getGenre());
            updatedGame.setDescription(game.getDescription());
            updatedGame.setPrice(game.getPrice());
            return gameRepository.save(updatedGame);
        }
        return null;
    }

    @Override
    public void deleteGame(Long id) {
        gameRepository.deleteById(id);
    }
}
