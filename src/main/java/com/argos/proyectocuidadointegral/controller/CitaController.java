package com.argos.proyectocuidadointegral.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@Controller
public class CitaController {

    @GetMapping("/citas")
    public String verCitas(Model model) {
        model.addAttribute("citas", new ArrayList<>());
        return "citas/lista";
    }
}
