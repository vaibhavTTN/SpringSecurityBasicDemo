package com.SpringSecurity.demo.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class userController {

    @GetMapping("/")
    public String Greet(){
        return "Hello";
    }
}
