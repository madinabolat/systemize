package com.example.systemize.controller;

import com.example.systemize.dto.UserLoginDto;
import com.example.systemize.dto.UserRegistrationDto;
import com.example.systemize.model.User;
import com.example.systemize.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class AuthController {
    private UserServiceImpl userServiceImpl;

    @Autowired
    public AuthController(UserServiceImpl userServiceImpl){
        this.userServiceImpl = userServiceImpl;
    }

    @PostMapping("/register")
    public User register(@RequestBody UserRegistrationDto userData){
        return userServiceImpl.registerUser(userData);
    }

    @PostMapping("/login")
    public String login(@RequestBody UserLoginDto userData){
        return userServiceImpl.loginUser(userData);

    }

    @PostMapping("/ping")
    public String ping(){
        return "pong";
    }
}
