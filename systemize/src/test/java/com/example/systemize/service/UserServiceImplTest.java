package com.example.systemize.service;

import com.example.systemize.dto.UserRegistrationDto;
import com.example.systemize.exception.userAlreadyExistsException;
import com.example.systemize.model.User;
import com.example.systemize.respository.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.security.crypto.password.PasswordEncoder;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class UserServiceImplTest {
    UserRepository userRepository = mock(UserRepository.class);
    PasswordEncoder passwordEncoder = mock(PasswordEncoder.class);

    @Test
    public void ShouldRegisterNewUserSuccessfully(){
        UserRegistrationDto userData = new UserRegistrationDto("madina", "123");

        when(userRepository.findByUsername(userData.getUsername())).thenReturn(null);
        when(passwordEncoder.encode(userData.getPassword())).thenReturn("123encoded");
        when(userRepository.save(any(User.class))).thenAnswer(invocation -> invocation.getArgument(0));

        UserServiceImpl userService = new UserServiceImpl(userRepository, passwordEncoder);

        User savedUser = userService.registerUser(userData);

        assertEquals("madina", savedUser.getUsername());
        assertEquals("123encoded", savedUser.getPasswordHash());
    }

    @Test
    public void ThrowsExceptionWhenAttemptToRegisterExistingUsername(){
        UserRegistrationDto userData = new UserRegistrationDto("madina", "123");
        User existingUser = new User();
        existingUser.setUsername("madina");
        when(userRepository.findByUsername(userData.getUsername())).thenReturn(existingUser); //need to return user
        UserServiceImpl userService = new UserServiceImpl(userRepository, passwordEncoder);
        //how to add that userService.registerUser(userData) user already exists?
        Exception e = assertThrows(userAlreadyExistsException.class, () -> userService.registerUser(userData) );
        assertEquals("The user already exists", e.getMessage());
    }

    @Test
    public void TestFindExistingUser(){

    }

    @Test
    public void TestFindNonexistentUser(){

    }




}