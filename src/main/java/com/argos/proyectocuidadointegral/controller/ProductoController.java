package com.argos.proyectocuidadointegral.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@Controller
public class ProductoController {

    @GetMapping("/productos")
    public String verProductos(Model model) {
        model.addAttribute("producto", new ArrayList<>());
        return "productos/lista";
    }

}
