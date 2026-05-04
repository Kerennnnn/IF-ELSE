package com.if_else.erronka.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.if_else.erronka.model.Eraikina;
import com.if_else.erronka.service.EraikinakService;

import jakarta.validation.Valid;

@Controller
public class EraikinakController {
    private final EraikinakService eraikinakService;

    @Autowired
    public EraikinakController(EraikinakService eraikinakService) {
        this.eraikinakService = eraikinakService;
    }

    @GetMapping({ "/admin/eraikinak", "/app/eraikinak" })
    public String eraikinak(@RequestParam(required = false) String search, Model model) {
        model.addAttribute("eraikinak", eraikinakService.eraikinakFiltratu(search));
        return "eraikinak";
    }

    @PostMapping("/admin/eraikinak/delete")
    public String deleteGailua(@RequestParam Integer id) {
        eraikinakService.eraikinaEzabatu(id);

        return "redirect:/admin/eraikinak";
    }

    @GetMapping("/admin/eraikinak/gehitu")
    public String gailuakGehitu(@RequestParam(required = false) Integer id, Model model) {
        model.addAttribute("eraikina", eraikinakService.eraikina(id));

        return "eraikinakGehitu";
    }

    @PostMapping("/admin/eraikinak/gehitu")
    public String eraikinaGorde(@Valid @ModelAttribute("eraikina") Eraikina eraikina, BindingResult result,
            Model model) {

        if (result.hasErrors()) {
            return "eraikinakGehitu";
        }

        eraikinakService.eraikinaGorde(eraikina);

        return "redirect:/admin/eraikinak";
    }

}
