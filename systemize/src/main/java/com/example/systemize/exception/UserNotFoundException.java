package com.example.systemize.exception;

public class UserNotFoundException extends RuntimeException {
    public UserNotFoundException(String noSuchUserExists) {
        super(noSuchUserExists);
    }
}
