package com.example.gilmoregameflixproject.repository;

import com.example.gilmoregameflixproject.model.Game;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.io.Serializable;

@Repository
public interface GameRepository extends JpaRepository<Game, Long>, Serializable {
}
