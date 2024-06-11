package com.hailybelle.dashboard.controllers;

import com.hailybelle.dashboard.models.DashboardComponent;
import com.hailybelle.dashboard.services.DashboardComponentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.security.Principal;

@Controller
public class DashboardComponentController {
    @Autowired
    private DashboardComponentService dashboardComponentService;

    @GetMapping("/components")
    public String showComponentForm(Model model) {
        model.addAttribute("dashboardComponent", new DashboardComponent());
        return "components";
    }

    @PostMapping("/components")
    public String saveComponent(@ModelAttribute DashboardComponent component, Principal principal) {
        component.setUserId(principal.getName());
        dashboardComponentService.saveDashboardComponent(component);
        return "redirect:/dashboard";
    }
}

