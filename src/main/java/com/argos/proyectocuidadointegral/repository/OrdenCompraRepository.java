package com.argos.proyectocuidadointegral.repository;

import com.argos.proyectocuidadointegral.model.OrdenCompra;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface OrdenCompraRepository extends JpaRepository<OrdenCompra, Long> {
    List<OrdenCompra> findByClienteIdCliente(Integer idCliente);
    List<OrdenCompra> findByEstado(String estado);
}
