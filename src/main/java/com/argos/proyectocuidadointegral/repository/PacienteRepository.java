package com.argos.proyectocuidadointegral.repository;

import com.argos.proyectocuidadointegral.model.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface PacienteRepository extends JpaRepository<Paciente, Long> {
    List<Paciente> findByNameContainingIgnoreCaseOrOwnerContainingIgnoreCase(String name, String owner);
    List<Paciente> findBySpecies(String species);
}