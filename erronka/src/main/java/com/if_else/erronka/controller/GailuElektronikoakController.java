package com.if_else.erronka.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.if_else.erronka.model.GailuElektronikoa;
import com.if_else.erronka.repository.GailuElektronikoaRepository;

@Controller
public class GailuElektronikoakController {

    private final GailuElektronikoaRepository gailuElektronikoaRepository;

    @Autowired
    public GailuElektronikoakController(GailuElektronikoaRepository gailuElektronikoaRepository) {
        this.gailuElektronikoaRepository = gailuElektronikoaRepository;
    }

    @GetMapping("/gailuak")
    public String gailuak(@RequestParam(required = false) String egoera, @RequestParam(required = false) String string,
            Model model) {
        model.addAttribute("gailuakGuztira", gailuElektronikoaRepository.count());
        model.addAttribute("aktiboak", gailuElektronikoaRepository.countByEgoera("Aktiboa"));
        model.addAttribute("konponketan", gailuElektronikoaRepository.countByEgoera("Konponketan"));
        model.addAttribute("maileguan", gailuElektronikoaRepository.countByEgoera("Maileguan"));

        if (egoera != null) {
            List<GailuElektronikoa> emaitza = gailuElektronikoaRepository.findByEgoera(egoera);
            if (!emaitza.isEmpty()) {
                model.addAttribute("egoera", egoera);
                model.addAttribute("gailuak", emaitza);
            } else {
                model.addAttribute("egoera", "Egoera guztiak");
                model.addAttribute("gailuak", gailuElektronikoaRepository.findAll());
            }
        } else if (string != null) {
            model.addAttribute("egoera", "Egoera guztiak");
            model.addAttribute("gailuak",
                    gailuElektronikoaRepository.findByIzenaContainingOrMarkaContaining(string, string));
        } else {
            model.addAttribute("egoera", "Egoera guztiak");
            model.addAttribute("gailuak", gailuElektronikoaRepository.findAll());
        }

        return "gailuElektronikoak";
    }

    // @PostMapping("/gailuak")
    // public String postMethodName(@RequestParam String egoera, Model model) {
    // model.addAttribute("gailuakGuztira", gailuElektronikoaRepository.count());
    // model.addAttribute("aktiboak",
    // gailuElektronikoaRepository.countByEgoera("Aktiboa"));
    // model.addAttribute("konponketan",
    // gailuElektronikoaRepository.countByEgoera("Konponketan"));
    // model.addAttribute("maileguan",
    // gailuElektronikoaRepository.countByEgoera("Maileguan"));
    // model.addAttribute("egoera", egoera);

    // List<GailuElektronikoa> emaitza =
    // gailuElektronikoaRepository.findByEgoera(egoera);
    // if (!emaitza.isEmpty())
    // model.addAttribute("gailuak", emaitza);
    // else
    // model.addAttribute("gailuak", gailuElektronikoaRepository.findAll());

    // return "gailuElektronikoak";
    // }

    // @PostMapping("/gailuak-proba")
    // public String proba(@RequestParam String string, Model model) {
    // model.addAttribute("gailuakGuztira", gailuElektronikoaRepository.count());
    // model.addAttribute("aktiboak",
    // gailuElektronikoaRepository.countByEgoera("Aktiboa"));
    // model.addAttribute("konponketan",
    // gailuElektronikoaRepository.countByEgoera("Konponketan"));
    // model.addAttribute("maileguan",
    // gailuElektronikoaRepository.countByEgoera("Maileguan"));

    // model.addAttribute("gailuak",
    // gailuElektronikoaRepository.findByIzenaContainingOrMarkaContaining(string,
    // string));

    // return "gailuElektronikoak";
    // }

}
