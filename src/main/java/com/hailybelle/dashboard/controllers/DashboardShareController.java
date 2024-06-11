package com.hailybelle.dashboard.controllers;

import com.hailybelle.dashboard.models.DashboardConfiguration;
import com.hailybelle.dashboard.models.Share;
import com.hailybelle.dashboard.services.DashboardConfigurationService;
import com.hailybelle.dashboard.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.security.Principal;

@Controller
public class DashboardShareController {

    @Autowired
    private DashboardConfigurationService dashboardConfigurationService;

    @Autowired
    private UserService userService;

    @GetMapping("/share")
    public String showShareForm(Model model) {
        model.addAttribute("share", new Share());
        return "share";
    }

    @PostMapping("/share")
    public String shareDashboard(@ModelAttribute Share share, Principal principal) {
        String senderUsername = principal.getName();
        String recipientUsername = share.getUsername();

        // Fetch the dashboard configuration of the sender
        DashboardConfiguration config = dashboardConfigurationService.findByUserId(senderUsername);

        // Ensure the recipient exists
        if (userService.findByUsername(recipientUsername) != null && config != null) {
            // Create a copy of the dashboard configuration for the recipient
            DashboardConfiguration sharedConfig = new DashboardConfiguration();
            sharedConfig.setUserId(recipientUsername);
            sharedConfig.setConfiguration(config.getConfiguration());

            // Save the shared configuration
            dashboardConfigurationService.saveDashboardConfiguration(sharedConfig);
        }

        return "redirect:/dashboard";
    }
}


