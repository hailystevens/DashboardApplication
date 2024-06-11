package com.hailybelle.dashboard.repositories;

import com.hailybelle.dashboard.models.Customization;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomizationRepository extends JpaRepository<Customization, Long> {
    Customization findByUserId(String userId);
}


