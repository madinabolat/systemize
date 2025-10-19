package com.example.systemize.service;

import com.example.systemize.dto.UserLoginDto;
import com.example.systemize.dto.UserRegistrationDto;
import com.example.systemize.model.User;

public interface UserService {
    public User registerUser(UserRegistrationDto userData);
    public User findByUsername(String username);
    public String loginUser(UserLoginDto userData);
}
