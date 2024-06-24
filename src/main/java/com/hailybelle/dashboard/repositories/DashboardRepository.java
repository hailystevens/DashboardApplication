package com.hailybelle.dashboard.repositories;

import com.hailybelle.dashboard.models.Dashboard;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DashboardRepository extends JpaRepository<Dashboard, Long> {
    // Additional query methods if needed
}
