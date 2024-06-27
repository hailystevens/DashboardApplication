package com.hailybelle.dashboard.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.hailybelle.dashboard.models.User;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUsername(String username);
    Optional<User> findByEmail(String email);
}
