package com.example.systemize.service;

import com.example.systemize.dto.UserLoginDto;
import com.example.systemize.dto.UserRegistrationDto;
import com.example.systemize.model.User;
import com.example.systemize.respository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService{
    private UserRepository userRepository;
    private PasswordEncoder passwordEncoder;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, PasswordEncoder passwordEncoder){
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public User registerUser(UserRegistrationDto userData) {
        User user = new User();
        //check if User exists
        
        user.setUsername(userData.getUsername());
        user.setPasswordHash(passwordEncoder.encode(userData.getPassword()));
        return userRepository.save(user);
    }

    @Override
    public String loginUser(UserLoginDto userData) {
        User user = userRepository.findByUsername(userData.getUsername());
        if (user == null) {
            System.out.println("user is null");
        }

        if (passwordEncoder.matches(userData.getPassword(), user.getPasswordHash())){
            System.out.println("Password matched");
            return "User logged in";
        }
        return "User not found";
    }

    @Override
    public User findByUsername(String username) {
        return userRepository.findByUsername(username);
    }
}
