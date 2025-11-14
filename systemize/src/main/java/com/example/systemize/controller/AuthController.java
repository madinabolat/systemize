package com.example.systemize.controller;

import com.example.systemize.dto.UserLoginDto;
import com.example.systemize.dto.UserRegistrationDto;
import com.example.systemize.exception.UserNotFoundException;
import com.example.systemize.model.User;
import com.example.systemize.service.UserServiceImpl;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.ErrorResponse;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

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
        try{
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(userServiceImpl.loginUser(userData));
        }
        catch (UserNotFoundException e)
        {
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body(e.getMessage());

        }
    }

    @PostMapping("/ping")
    public String ping(){
        return "pong";
    }

    //add general exception handling?
}
