package com.if_else.erronka.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.if_else.erronka.model.Solairua;
import com.if_else.erronka.service.SolairuakService;

import jakarta.validation.Valid;

@Controller
public class SolairuakController {
    private final SolairuakService solairuakService;

    @Autowired
    public SolairuakController(SolairuakService solairuakService) {
        this.solairuakService = solairuakService;
    }

    @GetMapping({ "/admin/solairuak", "/app/solairuak" })
    public String solairuak(@RequestParam(required = false) Integer search, Model model) {
        model.addAttribute("solairuak", solairuakService.solairuakFiltratu(search));
        return "solairuak";
    }

    @PostMapping("/admin/solairuak/delete")
    public String deleteSolairua(@RequestParam Integer id) {
        solairuakService.solairuaEzabatu(id);

        return "redirect:/admin/solairuak";
    }

    @GetMapping("/admin/solairuak/gehitu")
    public String solairuakGehitu(@RequestParam(required = false) Integer id, Model model) {
        model.addAttribute("solairua", solairuakService.solairua(id));
        model.addAttribute("eraikinak", solairuakService.eraikinak());

        return "solairuakGehitu";
    }

    @PostMapping("/admin/solairuak/gehitu")
    public String solairuaGorde(@Valid @ModelAttribute("solairua") Solairua solairua,
            BindingResult result,
            Model model) {

        if (result.hasErrors()) {
            model.addAttribute("eraikinak", solairuakService.eraikinak());
            return "solairuakGehitu";
        }

        solairuakService.solairuaGorde(solairua);

        return "redirect:/admin/solairuak";
    }
}
