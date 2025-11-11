package com.example.systemize.service;

import com.example.systemize.controller.AuthController;
import com.example.systemize.dto.UserRegistrationDto;
import com.example.systemize.model.User;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

public class AuthControllerTest {
    MockMvc mockMvc;
    UserServiceImpl userService  = mock(UserServiceImpl.class);
    AuthController authController;

    @BeforeEach
    public void test() {
        this.authController = new AuthController(userService);
        this.mockMvc = MockMvcBuilders.standaloneSetup(authController).build();
    }

//    POST /api/auth/register: Test successful registration and invalid input.
//    POST /api/auth/login: Test successful login, incorrect credentials, and non-existent usernames.
//    Use MockMvc to simulate HTTP requests and mock UserService and PasswordEncoder.

//    @PostMapping("/register")
//    public ResponseEntity<User> register(@RequestBody UserRegistrationDto userData){
//        return ResponseEntity
//                .status(HttpStatus.CREATED)
//                .body(userServiceImpl.registerUser(userData));
//    }

    @Test
    public void registersNewUserSuccessfully() throws Exception {
        UserRegistrationDto userData = new UserRegistrationDto("madina", "123");
        ObjectMapper objectMapper = new ObjectMapper();
        User newUser = new User();
        newUser.setUsername("madina");
        newUser.setPasswordHash("123hash");

        when(userService.registerUser(any(UserRegistrationDto.class))).thenReturn(newUser);

        mockMvc.perform(post("/api/auth/register")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(userData))
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.username").value(newUser.getUsername()))
                .andExpect(jsonPath("$.passwordHash").value(newUser.getPasswordHash()));
    }
}
