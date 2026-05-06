package com.if_else.erronka.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.if_else.erronka.model.Gela;
import com.if_else.erronka.service.GelakService;

import jakarta.validation.Valid;

@Controller
public class GelakController {
    private final GelakService gelakService;

    @Autowired
    public GelakController(GelakService gelakService) {
        this.gelakService = gelakService;
    }

    @GetMapping({ "/admin/gelak", "/app/gelak" })
    public String gelak(@RequestParam(required = false) Integer search, Model model) {
        model.addAttribute("gelak", gelakService.gelakFiltratu(search));
        return "gelak";
    }

    @PostMapping("/admin/gelak/delete")
    public String deleteGelak(@RequestParam Integer id) {
        gelakService.gelaEzabatu(id);

        return "redirect:/admin/gelak";
    }

    @GetMapping("/admin/gelak/gehitu")
    public String gelakGehitu(@RequestParam(required = false) Integer id, Model model) {
        model.addAttribute("gela", gelakService.gela(id));
        model.addAttribute("solairuak", gelakService.solairuak());

        return "gelakGehitu";
    }

    @PostMapping("/admin/gelak/gehitu")
    public String gelaGorde(@Valid @ModelAttribute("gela") Gela gela,
            BindingResult result,
            Model model) {

        if (result.hasErrors()) {
            model.addAttribute("solairuak", gelakService.solairuak());
            return "gelakGehitu";
        }

        gelakService.gelaGorde(gela);

        return "redirect:/admin/gelak";
    }
}
