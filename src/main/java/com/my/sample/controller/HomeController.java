package com.my.sample.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
public class HomeController {

    @GetMapping("")
    public String index() {
        return "Spring Data MongoDB示例代码工程";
    }

    @GetMapping("now")
    public Date now() {
        return new Date();
    }
}
