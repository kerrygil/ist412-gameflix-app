package com.example.gilmoregameflixproject.service;

import com.example.gilmoregameflixproject.model.Game;
import com.example.gilmoregameflixproject.model.User;
import com.example.gilmoregameflixproject.repository.GameRepository;
import com.example.gilmoregameflixproject.repository.UserRepository;
import com.example.gilmoregameflixproject.service.LibraryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LibraryServiceImpl implements LibraryService {

    @Autowired
    private GameRepository gameRepository;

    @Autowired
    private UserRepository userRepository;

    @Override
    public List<Game> getLibraryGames(User user) {
        return user.getLibraryGames();
    }

    @Override
    public void addGamesToLibrary(User user, List<Long> gameIds) {
        List<Game> games = gameRepository.findAllById(gameIds);
        user.getLibraryGames().addAll(games);
        userRepository.save(user);
    }

    @Override
    public void removeGamesFromLibrary(User user, List<Long> gameIds) {
        List<Game> games = gameRepository.findAllById(gameIds);
        user.getLibraryGames().removeAll(games);
        userRepository.save(user);
    }
}

