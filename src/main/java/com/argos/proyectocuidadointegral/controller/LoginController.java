package com.argos.proyectocuidadointegral.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {

    // Al entrar a http://localhost:8080/login, Spring sabrá qué HTML mostrar
    @GetMapping("/login")
    public String mostrarLogin() {
        return "public/login"; // Busca exactamente src/main/resources/templates/public/login.html
    }
}
