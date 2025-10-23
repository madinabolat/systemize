package com.example.systemize.dto;

public class UserRegistrationDto {
    private String username;
    private String password;

    public UserRegistrationDto(String username, String password){
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword(){
        return password;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password){
        this.password = password;
    }
}
