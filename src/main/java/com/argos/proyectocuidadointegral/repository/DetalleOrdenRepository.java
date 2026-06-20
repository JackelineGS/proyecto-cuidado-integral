package com.argos.proyectocuidadointegral.repository;

import com.argos.proyectocuidadointegral.model.DetalleOrden;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface DetalleOrdenRepository extends JpaRepository<DetalleOrden, Long> {
    List<DetalleOrden> findByOrdenCompraIdOrden(Long idOrden);
    List<DetalleOrden> findByProductoIdProducto(Long idProducto);
}
