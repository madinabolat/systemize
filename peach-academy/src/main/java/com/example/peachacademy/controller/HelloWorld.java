package com.example.peachacademy.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

//why @RestController? not just Controller?
@RestController
public class HelloWorld {
    //? what is @RequestMapping
    @GetMapping("/hello")
    public String HelloWorld(){
        return "Hello World!!";
    }
    //can also return html here
    //the file will leave in resources?
}
