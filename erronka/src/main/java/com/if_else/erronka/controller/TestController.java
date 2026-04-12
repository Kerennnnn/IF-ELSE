package com.if_else.erronka.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @GetMapping("/hello")
    public String hello() {
        return "Welcome! You are successfully authenticated.";
    }

    @GetMapping("/home")
    public String home() {
        return "Orri nagusia!";
    }

    @GetMapping("/user")
    public String user() {
        return "USER";
    }

    @GetMapping("/admin")
    public String admin() {
        return "ADMIN";
    }

}
