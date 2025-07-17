package com.example.gilmoregameflixproject.repository;

import com.example.gilmoregameflixproject.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {

    Optional<User> findByUsername(String username); // Used for login

    boolean existsByUsername(String username); // Used for registration
}
