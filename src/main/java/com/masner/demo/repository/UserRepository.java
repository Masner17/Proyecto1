package com.masner.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.masner.demo.model.User;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByName(String name);

    Boolean existsByName(String name);

}
