package com.argos.proyectocuidadointegral.service;

import com.argos.proyectocuidadointegral.enums.CategoriaProducto;
import com.argos.proyectocuidadointegral.enums.EstadoProducto;
import com.argos.proyectocuidadointegral.model.Producto;
import com.argos.proyectocuidadointegral.repository.ProductoRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class ProductoService {

    private final ProductoRepository productoRepository;

    public ProductoService(ProductoRepository productoRepository) {
        this.productoRepository = productoRepository;
    }

    public List<Producto> listarTodos() {
        return productoRepository.findAll();
    }

    public Optional<Producto> buscarPorId(Integer id) {
        return productoRepository.findById(id);
    }

    public List<Producto> buscarPorNombre(String nombre) {
        return productoRepository.findByNombreContainingIgnoreCase(nombre);
    }

    public List<Producto> buscarPorCategoria(CategoriaProducto categoria) {
        return productoRepository.findByCategoria(categoria);
    }

    public List<Producto> listarStockBajo() {
        return productoRepository.findAll().stream()
                .filter(p -> p.getStock() != null && p.getStockMinimo() != null
                        && p.getStock() <= p.getStockMinimo())
                .toList();
    }

    @Transactional
    public Producto guardar(Producto producto) {
        if (producto.getStock() != null && producto.getStockMinimo() != null
                && producto.getStock() <= producto.getStockMinimo()) {
            producto.setEstado(EstadoProducto.EN_REPOSICION);
        } else if (producto.getStock() != null && producto.getStock() == 0) {
            producto.setEstado(EstadoProducto.AGOTADO);
        } else if (producto.getEstado() == null) {
            producto.setEstado(EstadoProducto.DISPONIBLE);
        }
        return productoRepository.save(producto);
    }

    @Transactional
    public void eliminar(Integer id) {
        productoRepository.deleteById(id);
    }

    @Transactional
    public void actualizarStock(Integer idProducto, int cantidad, String tipo) {
        Producto producto = productoRepository.findById(idProducto)
                .orElseThrow(() -> new RuntimeException("Producto no encontrado"));
        if ("ENTRADA".equals(tipo)) {
            producto.setStock(producto.getStock() + cantidad);
        } else if ("SALIDA".equals(tipo)) {
            if (producto.getStock() < cantidad) {
                throw new RuntimeException("Stock insuficiente");
            }
            producto.setStock(producto.getStock() - cantidad);
        }
        guardar(producto);
    }
}
