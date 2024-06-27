package com.hailybelle.dashboard.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/auth")
public class AuthController {

    @GetMapping("/signin")
    public String showSignInForm() {
        return "sign_in";
    }

    @PostMapping("/signin")
    public String signIn(@RequestParam String username, @RequestParam String password) {
        // Authenticate user
        return "redirect:/dashboard";
    }

    @GetMapping("/signup")
    public String showSignUpForm() {
        return "sign_up";
    }

    @PostMapping("/signup")
    public String signUp(@RequestParam String username, @RequestParam String email, @RequestParam String password) {
        // Register user
        return "redirect:/auth/signin";
    }
}
