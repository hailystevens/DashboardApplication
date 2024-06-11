package com.hailybelle.dashboard.services;

import com.hailybelle.dashboard.models.Customization;
import com.hailybelle.dashboard.repositories.CustomizationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomizationService {

    @Autowired
    private CustomizationRepository customizationRepository;

    public Customization getCustomizationByUserId(String userId) {
        return customizationRepository.findByUserId(userId);
    }

    public void saveCustomization(Customization customization) {
        customizationRepository.save(customization);
    }
}

