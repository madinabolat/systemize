package com.example.peachacademy.controller;

//import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorld {
    //? what is @RequestMapping
    @GetMapping("/hello")
    public String HelloWorld(){
        return "Hello World!!";
    }
}
