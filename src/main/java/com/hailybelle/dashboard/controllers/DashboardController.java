package com.hailybelle.dashboard.controllers;

import com.hailybelle.dashboard.models.Customization;
import com.hailybelle.dashboard.models.DashboardComponent;
import com.hailybelle.dashboard.services.CustomizationService;
import com.hailybelle.dashboard.services.DashboardComponentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.security.Principal;
import java.util.List;

@Controller
public class DashboardController {

    @Autowired
    private CustomizationService customizationService;

    @Autowired
    private DashboardComponentService dashboardComponentService;

    @GetMapping("/dashboard")
    public String showDashboard(Model model, Principal principal) {
        String userId = principal.getName();

        // Fetch user customizations
        Customization customization = customizationService.getCustomizationByUserId(userId);
        model.addAttribute("customization", customization);

        // Fetch dashboard components
        List<DashboardComponent> components = dashboardComponentService.findByUserId(userId);
        model.addAttribute("components", components);

        return "dashboard";
    }
}




