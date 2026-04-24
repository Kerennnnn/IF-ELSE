package com.if_else.erronka.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.if_else.erronka.repository.GailuElektronikoaRepository;
import com.if_else.erronka.service.GailuElektronikoakService;

@Controller
public class GailuElektronikoakController {

    private final GailuElektronikoakService gailuElektronikoaKService;

    @Autowired
    public GailuElektronikoakController(GailuElektronikoakService gailuElektronikoaKService,
            GailuElektronikoaRepository gailuElektronikoaRepository) {
        this.gailuElektronikoaKService = gailuElektronikoaKService;
    }

    @GetMapping({ "/admin/gailuak", "/app/gailuak" })
    public String gailuak(@RequestParam(required = false) String egoera, @RequestParam(required = false) String search,
            Model model) {
        model.addAttribute("gailuakGuztira", gailuElektronikoaKService.gailuakKontatu("Egoera guztiak"));
        model.addAttribute("aktiboak", gailuElektronikoaKService.gailuakKontatu("Aktiboa"));
        model.addAttribute("konponketan", gailuElektronikoaKService.gailuakKontatu("Konponketan"));
        model.addAttribute("maileguan", gailuElektronikoaKService.gailuakKontatu("Maileguan"));

        model.addAttribute("egoera", gailuElektronikoaKService.gailuarenEgoera(egoera));

        model.addAttribute("gailuak", gailuElektronikoaKService.gailuakFiltratu(search, egoera));
        return "gailuElektronikoak";
    }

    @PostMapping("/admin/gailuak/delete")
    public String deleteGailua(@RequestParam Integer id) {
        gailuElektronikoaKService.gailuaEzabatu(id);

        return "redirect:/admin/gailuak";
    }

    @GetMapping("/gailuak/gehitu")
    public String gailuakGehitu() {
        return "gailuakGehitu";
    }
}
