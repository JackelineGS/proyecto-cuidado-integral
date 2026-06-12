package com.argos.proyectocuidadointegral.controller;

import com.argos.proyectocuidadointegral.model.Paciente;
import com.argos.proyectocuidadointegral.repository.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/pacientes")
public class PacienteController {

    @Autowired
    private PacienteRepository pacienteRepository;

    @GetMapping("/lista")
    public String listarPacientes(Model model){
        model.addAttribute("ListaPacientes",pacienteRepository.findAll());
        return "pacientes/lista";
    }

    @GetMapping("/detalle/{id}")
    public String verDetalle(@PathVariable Long id, Model model){
        Paciente paciente = pacienteRepository.findById(id).orElse(null);
        model.addAttribute("paciente",paciente);
        return "pacientes/detalle";
    }
}
