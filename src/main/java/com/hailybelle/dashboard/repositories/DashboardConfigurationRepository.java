package com.hailybelle.dashboard.repositories;

import com.hailybelle.dashboard.models.DashboardConfiguration;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DashboardConfigurationRepository extends JpaRepository<DashboardConfiguration, Long> {
    DashboardConfiguration findByUserId(String userId);
}

