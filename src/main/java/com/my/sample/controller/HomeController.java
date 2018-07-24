package com.my.sample.controller;

import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Api
@RestController
public class HomeController {

    @GetMapping("hello")
    public String hello() {
        return "Hello World!";
    }
}
