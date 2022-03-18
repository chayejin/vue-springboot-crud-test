package com.test.vueproject.controller;


import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@AllArgsConstructor
public class UserController {

    @GetMapping("/")
    public String home(){
        return "index";
    }
}
