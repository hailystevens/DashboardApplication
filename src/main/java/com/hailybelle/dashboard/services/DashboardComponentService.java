package com.hailybelle.dashboard.services;

import com.hailybelle.dashboard.models.DashboardComponent;
import com.hailybelle.dashboard.repositories.DashboardComponentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DashboardComponentService {

    @Autowired
    private DashboardComponentRepository dashboardComponentRepository;

    public List<DashboardComponent> findByUserId(String userId) {
        return dashboardComponentRepository.findByUserId(userId);
    }

    public void saveDashboardComponent(DashboardComponent component) {
        dashboardComponentRepository.save(component);
    }
}




