package com.hailybelle.dashboard.repositories;

import com.hailybelle.dashboard.models.DashboardComponent;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DashboardComponentRepository extends JpaRepository<DashboardComponent, Long> {
    List<DashboardComponent> findByUserId(String userId);
}
