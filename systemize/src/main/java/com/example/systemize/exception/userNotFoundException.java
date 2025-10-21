package com.example.systemize.exception;

public class userNotFoundException extends RuntimeException {
    public userNotFoundException(String noSuchUserExists) {
        super(noSuchUserExists);
    }
}
