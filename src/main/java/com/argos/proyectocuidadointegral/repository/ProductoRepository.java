package com.argos.proyectocuidadointegral.repository;

import com.argos.proyectocuidadointegral.enums.CategoriaProducto;
import com.argos.proyectocuidadointegral.enums.EstadoProducto;
import com.argos.proyectocuidadointegral.model.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface ProductoRepository extends JpaRepository<Producto, Integer> {
    List<Producto> findByCategoria(CategoriaProducto categoria);
    List<Producto> findByEstado(EstadoProducto estado);
    List<Producto> findByNombreContainingIgnoreCase(String nombre);
    List<Producto> findByStockLessThanEqual(Integer stockMinimo);
    List<Producto> findByCategoriaAndEstado(CategoriaProducto categoria, EstadoProducto estado);
}
