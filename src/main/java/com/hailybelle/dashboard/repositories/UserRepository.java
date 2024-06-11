package com.hailybelle.dashboard.repositories;

import com.hailybelle.dashboard.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
}


