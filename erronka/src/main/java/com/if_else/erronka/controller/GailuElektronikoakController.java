package com.if_else.erronka.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.if_else.erronka.repository.GailuElektronikoaRepository;

@Controller
public class GailuElektronikoakController {

    private final GailuElektronikoaRepository gailuElektronikoaRepository;

    @Autowired
    public GailuElektronikoakController(GailuElektronikoaRepository gailuElektronikoaRepository) {
        this.gailuElektronikoaRepository = gailuElektronikoaRepository;
    }

    @GetMapping("/gailuak")
    public String gailuak(Model model) {
        model.addAttribute("gailuak", gailuElektronikoaRepository.findAll());

        return "gailuElektronikoak";
    }

}
