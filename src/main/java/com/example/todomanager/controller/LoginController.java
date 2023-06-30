package com.example.todomanager.controller;

import com.example.todomanager.service.LoginService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

@Controller
public class LoginController {
    private LoginService service;

    public LoginController(LoginService service) {
        this.service = service;
    }

    @GetMapping("/login")
    public String getPage() {
        return "login";
    }

    @PostMapping("/login")
    public String login(@RequestParam String username, @RequestParam String password, ModelMap model) {
        if(this.service.validateUser(username, password)) {
            model.put("username", username);
            return "main";
        }
        else {
            model.put("errorMessage", "Invalid Credentials");
            return "login";
        }
    }
}
