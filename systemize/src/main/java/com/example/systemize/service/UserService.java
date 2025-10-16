package com.example.systemize.service;

import com.example.systemize.dto.UserRegistrationDto;
import com.example.systemize.model.User;

public interface UserService {
    public void registerUser(UserRegistrationDto userData);
    public User findByUsername(String username);
}
