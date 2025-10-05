package com.example.peachacademy.controller;

//import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
//@Controller is used to render html views
//@RestController is used for API
public class HelloWorld {
    //? what is @RequestMapping
    @GetMapping("/hello")
    public String HelloWorld(){
        return "Hello World!!";
    }
    //can also return html here
    //the file will leave in resources?
}
