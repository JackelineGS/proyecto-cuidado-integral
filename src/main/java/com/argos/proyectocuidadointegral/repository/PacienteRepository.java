package com.argos.proyectocuidadointegral.repository;

import com.argos.proyectocuidadointegral.model.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface PacienteRepository extends JpaRepository<Paciente, Integer> {

    List<Paciente> findByNameContainingIgnoreCaseOrClienteNombreContainingIgnoreCase(String name, String clienteNombre);
    List<Paciente> findBySpecies(String species);
}
