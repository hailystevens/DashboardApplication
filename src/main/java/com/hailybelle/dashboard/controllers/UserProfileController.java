package com.hailybelle.dashboard.controllers;

import com.hailybelle.dashboard.models.User;
import com.hailybelle.dashboard.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.security.Principal;

@Controller
public class UserProfileController {

    @Autowired
    private UserService userService;

    @GetMapping("/profile")
    public String showProfileForm(Model model, Principal principal) {
        User user = userService.findByUsername(principal.getName());
        model.addAttribute("user", user);
        return "profile";
    }

    @PostMapping("/profile")
    public String updateProfile(@ModelAttribute User user, Principal principal) {
        User existingUser = userService.findByUsername(principal.getName());
        existingUser.setPassword(new BCryptPasswordEncoder().encode(user.getPassword()));
        userService.saveUser(existingUser);
        return "redirect:/dashboard";
    }
}


