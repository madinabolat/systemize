package com.example.systemize.controller;

import com.example.systemize.dto.UserLoginDto;
import com.example.systemize.dto.UserRegistrationDto;
import com.example.systemize.model.User;
import com.example.systemize.service.UserServiceImpl;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<User> register(@Valid @RequestBody UserRegistrationDto userData){
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(userServiceImpl.registerUser(userData));
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody UserLoginDto userData){
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(userServiceImpl.loginUser(userData));
    }

    @PostMapping("/ping")
    public String ping(){
        return "pong";
    }
}
