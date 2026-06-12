package com.argos.proyectocuidadointegral.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LandingController {

    @GetMapping("/")
    public String verLanding() {
        return "public/landing"; // Apunta a templates/public/landing.html
    }

}
