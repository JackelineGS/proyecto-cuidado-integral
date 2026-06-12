package com.argos.proyectocuidadointegral.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@Controller
public class PacienteController {

    @GetMapping("/pacientes")
    public String verPatients(Model model) {
        model.addAttribute("pacientes", new ArrayList<>());
        return "pacientes/lista";
    }
}
