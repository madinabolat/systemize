package com.example.systemize.exception;

public class UserAlreadyExistsException extends RuntimeException {
    public UserAlreadyExistsException(String theUserAlreadyExists) {
        super(theUserAlreadyExists);
    }
}
