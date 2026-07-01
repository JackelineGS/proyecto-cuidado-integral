package com.argos.proyectocuidadointegral.controller;

import com.argos.proyectocuidadointegral.dto.CitaDTO;
import com.argos.proyectocuidadointegral.service.CitaService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;



@Controller
public class CitaController {

    private final CitaService citaService;
    public CitaController(CitaService citaService) {
        this.citaService = citaService;
    }

    @GetMapping("/citas")
public String verCitas(Model model) {
    List<CitaDTO> appointments = citaService.listarCitasDashboard();
    model.addAttribute("appointments", appointments);

    // Objeto vacío para el formulario de "Nueva Cita"
    model.addAttribute("cita", new CitaDTO());
    model.addAttribute("showForm", false); // Cambia a true si viene ?action=nuevo

    return "citas/lista";
    }
}