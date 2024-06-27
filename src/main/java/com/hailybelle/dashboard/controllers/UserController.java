package com.hailybelle.dashboard.controllers;

import com.hailybelle.dashboard.models.UserForm;
import com.hailybelle.dashboard.models.User;
import com.hailybelle.dashboard.repositories.UserRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Controller
public class UserController implements WebMvcConfigurer {

    @Autowired
    private UserRepository userRepository;

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/results").setViewName("results");
    }

    @GetMapping("/register")
    public String showRegistrationForm(UserForm userForm) {
        return "registration";  // This should match your registration.html template name
    }

    @PostMapping("/register")
    public String checkUserInfo(@Valid UserForm userForm, BindingResult bindingResult, Model model) {

        if (bindingResult.hasErrors()) {
            return "registration";  // This should match your registration.html template name
        }

        // Save the user to the database
        User user = new User();
        user.setUsername(userForm.getName());  // Using setUsername instead of setName
        user.setEmail(userForm.getEmail());
        user.setPassword(userForm.getPassword());
        user.setRole("USER"); // Assuming a single role "USER"
        userRepository.save(user);

        model.addAttribute("message", "User registered successfully");
        return "results";  // This should match your results.html template name
    }
}
