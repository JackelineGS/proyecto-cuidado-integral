package com.argos.proyectocuidadointegral.repository;

import com.argos.proyectocuidadointegral.model.SolicitudAdopcion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SolicitudAdopcionRepository extends JpaRepository<SolicitudAdopcion, Integer> {

    List<SolicitudAdopcion> findAllByOrderByCreatedAtDesc();

    long countByReadFalse();
}