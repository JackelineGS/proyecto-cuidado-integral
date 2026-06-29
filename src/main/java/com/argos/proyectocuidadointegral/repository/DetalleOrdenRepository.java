package com.argos.proyectocuidadointegral.repository;

import com.argos.proyectocuidadointegral.model.DetalleOrden;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface DetalleOrdenRepository extends JpaRepository<DetalleOrden, Integer> {
    List<DetalleOrden> findByOrdenCompraIdOrden(Integer idOrden);
    List<DetalleOrden> findByProductoIdProducto(Integer idProducto);
}
