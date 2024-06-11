package com.hailybelle.dashboard.controllers;

import com.hailybelle.dashboard.models.Customization;
import com.hailybelle.dashboard.services.CustomizationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.security.Principal;

@Controller
public class CustomizationController {

    @Autowired
    private CustomizationService customizationService;

    @GetMapping("/customize")
    public String showCustomizationForm(Model model, Principal principal) {
        Customization customization = customizationService.getCustomizationByUserId(principal.getName());
        if (customization == null) {
            customization = new Customization();
        }
        model.addAttribute("customization", customization);
        return "customize";
    }

    @PostMapping("/customize")
    public String saveCustomization(@ModelAttribute Customization customization, Principal principal) {
        customization.setUserId(principal.getName());
        customizationService.saveCustomization(customization);
        return "redirect:/dashboard";
    }
}
