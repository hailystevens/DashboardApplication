package com.hailybelle.dashboard.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/contact")
public class ContactController {

    @GetMapping
    public String showContactForm() {
        return "contact";
    }

    @PostMapping("/submit")
    public String submitContactForm(@RequestParam String name, @RequestParam String email, @RequestParam String message, Model model) {
        // Process contact form
        model.addAttribute("success", "Your message has been sent!");
        return "contact";
    }
}

