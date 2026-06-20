package com.argos.proyectocuidadointegral.repository;

import com.argos.proyectocuidadointegral.model.MovimientoStock;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface MovimientoStockRepository extends JpaRepository<MovimientoStock, Long> {
    List<MovimientoStock> findByProductoIdProducto(Long idProducto);
    List<MovimientoStock> findByTipo(String tipo);
}
