package com.sp.main.controller;

import com.sp.main.entity.User;
import com.sp.main.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserController {

        private final UserService userService;

        @Autowired
        public UserController(UserService userService) {
            this.userService = userService;
        }

        @GetMapping("/register")
        public String showRegistrationForm(Model model) {
            model.addAttribute("user", new User());
            return "register";
        }

        @PostMapping("/register")
        public String registerUser(@ModelAttribute("user") User user) {
            userService.save(user);
            return "redirect:/login";
        }
    @GetMapping("/login")
    public String showLoginPage() {
        return "login";
    }

        @GetMapping("/home")
        public String home() {
            return "home";
        }
    }


