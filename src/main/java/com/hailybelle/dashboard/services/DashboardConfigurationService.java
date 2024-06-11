package com.hailybelle.dashboard.services;

import com.hailybelle.dashboard.models.DashboardConfiguration;
import com.hailybelle.dashboard.repositories.DashboardConfigurationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DashboardConfigurationService {

    @Autowired
    private DashboardConfigurationRepository dashboardConfigurationRepository;

    public DashboardConfiguration findByUserId(String userId) {
        return dashboardConfigurationRepository.findByUserId(userId);
    }

    public void saveDashboardConfiguration(DashboardConfiguration config) {
        dashboardConfigurationRepository.save(config);
    }
}


