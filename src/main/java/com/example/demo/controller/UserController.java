package com.example.demo.controller;



import com.example.demo.entity.User;
import com.example.demo.service.UserService;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class UserController {

    private UserService userService;

    public UserController(UserService userService) {
		super();
		this.userService = userService;
	}
    
	@GetMapping("/register")
    public String showRegistrationForm(Model model) {
        model.addAttribute("user", new User());
        return "register";
    }

    @PostMapping("/register")
    public String registerUser(@ModelAttribute("user") User user, Model model) {
        if (!userService.save(user)) {
            model.addAttribute("error", "Username or email already exists. Please try again.");
            return "register";
        }
        model.addAttribute("message", "Registration successful!");
        return "login"; 
    }

    @GetMapping("/login")
    public String showLoginForm(Model model) {
        model.addAttribute("user", new User());
        return "login";
    }

    @PostMapping("/login")
    public String loginUser(@ModelAttribute("user") User user, Model model) {
        User existingUser = userService.findByUsername(user.getUsername());
        if (existingUser != null && existingUser.getPassword().equals(user.getPassword())) {
            return "redirect:/home"; // Redirect to a welcome page or dashboard
        } else {
            model.addAttribute("error", "Invalid username or password");
            return "login";
        }
    }
}
