package com.example.systemize.service;

import com.example.systemize.dto.UserLoginDto;
import com.example.systemize.dto.UserRegistrationDto;
import com.example.systemize.exception.UserAlreadyExistsException;
import com.example.systemize.exception.UserNotFoundException;
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
        if (userRepository.findByUsername(userData.getUsername()) != null){
            throw new UserAlreadyExistsException("The user already exists");
        }
        
        user.setUsername(userData.getUsername());
        user.setPasswordHash(passwordEncoder.encode(userData.getPassword()));
        return userRepository.save(user);
    }

    @Override
    public String loginUser(UserLoginDto userData) {
        User user = userRepository.findByUsername(userData.getUsername());
        if (user == null) {
            throw new UserNotFoundException("No such user exists");
        }

        if (passwordEncoder.matches(userData.getPassword(), user.getPasswordHash())){
            return "User logged in";
        } else {
            return "Wrong password. Please try again.";
        }
    }

    @Override
    public User findByUsername(String username) {
        return userRepository.findByUsername(username);
    }
}
