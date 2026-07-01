package com.argos.proyectocuidadointegral.repository;

import com.argos.proyectocuidadointegral.model.AtencionMedica;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AtencionMedicaRepository extends JpaRepository<AtencionMedica, Integer> {

    boolean existsByCitaId(Integer idCita);

}