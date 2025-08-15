package com.example.gilmoregameflixproject.model;

import jakarta.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "library")
public class Library {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Link to the user who owns the library
    @OneToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    // Games in library
    @ManyToMany
    @JoinTable(
            name = "library_games",
            joinColumns = @JoinColumn(name = "library_id"),
            inverseJoinColumns = @JoinColumn(name = "game_id")
    )
    private Set<Game> games = new HashSet<>();

    public Library() {}

    public Library(User user) {
        this.user = user;
    }

    public Long getId() { return id; }

    public User getUser() { return user; }
    public void setUser(User user) { this.user = user; }

    public Set<Game> getGames() { return games; }
    public void setGames(Set<Game> games) { this.games = games; }
}
