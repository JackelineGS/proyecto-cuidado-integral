package com.argos.proyectocuidadointegral.controller;

import com.argos.proyectocuidadointegral.model.HistoriaClinica;
import com.argos.proyectocuidadointegral.model.Paciente;
import com.argos.proyectocuidadointegral.model.Cliente;
import com.argos.proyectocuidadointegral.repository.HistoriaClinicaRepository;
import com.argos.proyectocuidadointegral.repository.PacienteRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.data.repository.CrudRepository;
import jakarta.persistence.EntityManager;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Controller
public class PacienteController {

    private final PacienteRepository pacienteRepository;
    private final EntityManager entityManager;
    private final HistoriaClinicaRepository historiaClinicaRepository;

    public PacienteController(PacienteRepository pacienteRepository, EntityManager entityManager, HistoriaClinicaRepository historiaClinicaRepository) {
        this.pacienteRepository = pacienteRepository;
        this.entityManager = entityManager;
        this.historiaClinicaRepository = historiaClinicaRepository;
    }

    @GetMapping("/pacientes")
    public String listarPacientes(
            @RequestParam(required = false) String searchTerm,
            @RequestParam(required = false, defaultValue = "Todos") String speciesFilter,
            @RequestParam(required = false) String action,
            @RequestParam(required = false) Integer id,
            Model model) {

        List<Paciente> pacientes;
        if (searchTerm != null && !searchTerm.trim().isEmpty()) {
            pacientes = pacienteRepository.findByNameContainingIgnoreCaseOrClienteNombreContainingIgnoreCase(searchTerm, searchTerm);
        } else if (speciesFilter != null && !speciesFilter.equals("Todos")) {
            pacientes = pacienteRepository.findBySpecies(speciesFilter);
        } else {
            pacientes = pacienteRepository.findAll();
        }

        model.addAttribute("pacientes", pacientes);
        model.addAttribute("searchTerm", searchTerm);
        model.addAttribute("speciesFilter", speciesFilter);

        boolean showForm = "nuevo".equals(action) || ("editar".equals(action) && id != null);
        Paciente pacienteForm = new Paciente();

        if ("editar".equals(action) && id != null) {
            pacienteForm = pacienteRepository.findById(id).orElse(new Paciente());
        }

        model.addAttribute("showForm", showForm);
        model.addAttribute("paciente", pacienteForm);

        return "pacientes/lista";
    }

    @PostMapping("/pacientes/guardar")
    @Transactional
    public String guardarPaciente(@ModelAttribute("paciente") Paciente paciente,
                                  @RequestParam("clienteId") Integer clienteId) {

        Cliente clienteReal = entityManager.getReference(Cliente.class, clienteId);
        paciente.setCliente(clienteReal);

        pacienteRepository.save(paciente);
        return "redirect:/pacientes";
    }

    @GetMapping("/pacientes/detalle/{id}")
    public String verDetalle(@PathVariable Integer id, Model model) {
        Paciente paciente = pacienteRepository.findById(id).orElse(null);
        model.addAttribute("paciente", paciente);
        if (paciente != null) {
            // Buscamos su historial o lo inicializamos si está vacío en Neon
            HistoriaClinica historia = historiaClinicaRepository.findByPacienteId(id)
                    .orElseGet(() -> historiaClinicaRepository.save(new HistoriaClinica(paciente)));

            model.addAttribute("historia", historia);
        }
        return "pacientes/detalle";
    }
}