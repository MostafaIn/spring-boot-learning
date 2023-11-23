package com.learnspringboot.hellospring;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class GradeController {
    @GetMapping("/hello")
    public String sayHello(){
        System.out.println("Hello everyone!");
        return "Hello everyone!";
    }
}

