package com.argos.proyectocuidadointegral.controller;

import com.argos.proyectocuidadointegral.repository.MascotaRescatadaRepository;
import com.argos.proyectocuidadointegral.repository.ProductoRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.beans.factory.annotation.Autowired;

@Controller
public class LandingController {

    @Autowired
    private MascotaRescatadaRepository mascotaRepository;

    @Autowired
    private ProductoRepository productoRepository;

    @GetMapping("/")
    public String verLanding(Model model) {

        model.addAttribute("adoptionPets", mascotaRepository.findAll());
        model.addAttribute("products", productoRepository.findAll());

        return "public/landing";
    }
}