package com.example.systemize.service;

import com.example.systemize.controller.AuthController;
import com.example.systemize.dto.UserRegistrationDto;
import com.example.systemize.model.User;
import com.example.systemize.respository.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class AuthControllerTest {


//    POST /api/auth/register: Test successful registration and invalid input.
//    POST /api/auth/login: Test successful login, incorrect credentials, and non-existent usernames.
//    Use MockMvc to simulate HTTP requests and mock UserService and PasswordEncoder.

//    @PostMapping("/register")
//    public ResponseEntity<User> register(@RequestBody UserRegistrationDto userData){
//        return ResponseEntity
//                .status(HttpStatus.CREATED)
//                .body(userServiceImpl.registerUser(userData));
//    }


    UserServiceImpl userService  = mock(UserServiceImpl.class);
    AuthController authController;

    @Test
    public void registersNewUserSuccessfully(){
        UserRegistrationDto userData = new UserRegistrationDto("madina", "123");
        User newUser = new User(); //do i need proper user with password?

        when(userService.registerUser(userData)).thenReturn(newUser);
        authController.register(userData)


    }



}
