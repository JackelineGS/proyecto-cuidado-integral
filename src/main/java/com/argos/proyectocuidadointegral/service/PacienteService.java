package com.argos.proyectocuidadointegral.service;

import com.argos.proyectocuidadointegral.model.Paciente;
import com.argos.proyectocuidadointegral.repository.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class PacienteService {

    @Autowired
    private PacienteRepository repository;

    public List<Paciente> listarTodos() {
        return repository.findAll();
    }

    public Paciente guardar(Paciente paciente) {
        return repository.save(paciente);
    }

    public Paciente buscarPorId(Long id) {
        return repository.findById(id).orElse(null);
    }

    public List<Paciente> buscarConFiltros(String searchTerm, String speciesFilter) {
        if (searchTerm != null && !searchTerm.trim().isEmpty()) {
            return repository.findByNameContainingIgnoreCaseOrOwnerContainingIgnoreCase(searchTerm, searchTerm);
        } else if (speciesFilter != null && !speciesFilter.equals("Todos")) {
            return repository.findBySpecies(speciesFilter);
        }
        return listarTodos();
    }
}