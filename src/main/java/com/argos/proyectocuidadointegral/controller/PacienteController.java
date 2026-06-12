package com.argos.proyectocuidadointegral.controller;

import com.argos.proyectocuidadointegral.model.Paciente;
import com.argos.proyectocuidadointegral.service.PacienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/pacientes")
public class PacienteController {

    @Autowired
    private PacienteService pacienteService;

    @GetMapping
    public String listarPacientes(
            @RequestParam(required = false) String searchTerm,
            @RequestParam(required = false, defaultValue = "Todos") String speciesFilter,
            @RequestParam(required = false) String action,
            @RequestParam(required = false) Long id,
            Model model) {

        List<Paciente> pacientes = pacienteService.buscarConFiltros(searchTerm, speciesFilter);
        model.addAttribute("filteredPets", pacientes);
        model.addAttribute("searchTerm", searchTerm);
        model.addAttribute("speciesFilter", speciesFilter);

        boolean showForm = false;
        Paciente pacienteForm = new Paciente();

        if ("nuevo".equals(action)) {
            showForm = true;
        } else if ("editar".equals(action) && id != null) {
            showForm = true;
            pacienteForm = pacienteService.buscarPorId(id);
        }

        model.addAttribute("showForm", showForm);
        model.addAttribute("paciente", pacienteForm);

        return "pacientes/lista";
    }

    @PostMapping("/guardar")
    public String guardarPaciente(@ModelAttribute("paciente") Paciente paciente) {
        pacienteService.guardar(paciente);
        return "redirect:/pacientes";
    }

    @GetMapping("/detalle/{id}")
    public String verDetalle(@PathVariable Long id, Model model) {
        Paciente paciente = pacienteService.buscarPorId(id);

        model.addAttribute("patient", paciente);
        model.addAttribute("attendedAppointments", new ArrayList<>());

        return "pacientes/detalle";
    }
}