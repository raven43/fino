package com.example.fino.controller;

import com.example.fino.domain.entity.User;
import com.example.fino.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
public class MainController {

    private final UserService userService;

    @GetMapping("/")
    public String index() {
        return "index";
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/register")
    public String register() {
        return "register";
    }

    @PostMapping("/register")
    public String addNewUser(User user, Model model) {
        if (userService.addUser(user)) {
            return "redirect:/login";
        } else {
            model.addAttribute("message", "User with such username already exist!");
            return "register";
        }
    }
}
