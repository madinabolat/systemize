package com.example.systemize.exception;

public class userAlreadyExistsException extends RuntimeException {
    public userAlreadyExistsException(String theUserAlreadyExists) {
        super(theUserAlreadyExists);
    }
}
