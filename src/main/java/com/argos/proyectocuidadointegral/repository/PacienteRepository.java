package com.argos.proyectocuidadointegral.repository;

import com.argos.proyectocuidadointegral.model.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PacienteRepository extends JpaRepository<Paciente,Long> {

}
