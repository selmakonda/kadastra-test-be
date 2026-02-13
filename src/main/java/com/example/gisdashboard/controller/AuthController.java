package com.example.gisdashboard.controller;

import com.example.gisdashboard.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public String register(@RequestParam String username, @RequestParam String password){
        userService.saveUser(username, password);
        return "User registered!";
    }

    @PostMapping("/login")
    public String login(@RequestParam String username, @RequestParam String password){
        if(userService.checkUser(username, password)){
            return "Login successful!";
        }
        return "Invalid credentials!";
    }
}
