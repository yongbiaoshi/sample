package com.my.sample.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
public class HomeController {

    @GetMapping("now")
    public Date now() {
        return new Date();
    }

    @GetMapping("hello")
    public String hello(){
        return "Hello Spring Boot!";
    }
}
