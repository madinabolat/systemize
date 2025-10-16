package com.example.systemize.service;

import com.example.systemize.dto.UserRegistrationDto;
import com.example.systemize.model.User;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService{
    @Override
    public void registerUser(UserRegistrationDto userData) {

    }

    @Override
    public User findByUsername(String username) {
        return null;
    }
}
