package com.argos.proyectocuidadointegral.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@Controller
public class ClienteController {

    @GetMapping("/clientes")
    public String verClientes(Model model) {
        model.addAttribute("clientes", new ArrayList<>());
        return "clientes/lista";
    }
}
