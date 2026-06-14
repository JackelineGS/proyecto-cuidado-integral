package com.argos.proyectocuidadointegral.repository;

import com.argos.proyectocuidadointegral.model.MascotaRescatada;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MascotaRescatadaRepository extends JpaRepository<MascotaRescatada, Integer> {

    List<MascotaRescatada> findByEstado(String estado);

    List<MascotaRescatada> findByNombreContainingIgnoreCase(String nombre);

    List<MascotaRescatada> findByEspecie(String especie);
}