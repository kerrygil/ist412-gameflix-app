package com.example.gilmoregameflixproject.repository;

import com.example.gilmoregameflixproject.model.Library;
import com.example.gilmoregameflixproject.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface LibraryRepository extends JpaRepository<Library, Long> {
    Optional<Library> findByUser(User user);
}
