package com.argos.proyectocuidadointegral.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@Controller
public class AdopcionController {

    @GetMapping("/adopciones")
    public String verAdopciones(Model model) {
        model.addAttribute("enadopcion", new ArrayList<>());
        return "adopciones/lista";
    }
}
