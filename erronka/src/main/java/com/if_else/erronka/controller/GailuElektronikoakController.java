package com.if_else.erronka.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class GailuElektronikoakController {
    @GetMapping("/gailuak")
    public String gailuak() {
        return "gailuElektronikoak";
    }

}
