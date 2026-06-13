package com.argos.proyectocuidadointegral.controller;

import com.argos.proyectocuidadointegral.model.Paciente;
import com.argos.proyectocuidadointegral.repository.PacienteRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import java.util.ArrayList;

@Controller
public class PacienteController {

    private final PacienteRepository pacienteRepository;
    public PacienteController(PacienteRepository pacienteRepository) { // Constructor
        this.pacienteRepository = pacienteRepository;
    }

    @GetMapping("/pacientes")
    public String verPatients(Model model) {
        model.addAttribute("pacientes", pacienteRepository.findAll());
        return "pacientes/lista";
    }
}
