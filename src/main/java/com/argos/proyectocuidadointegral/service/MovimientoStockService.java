package com.argos.proyectocuidadointegral.service;

import com.argos.proyectocuidadointegral.model.MovimientoStock;
import com.argos.proyectocuidadointegral.model.Producto;
import com.argos.proyectocuidadointegral.repository.MovimientoStockRepository;
import com.argos.proyectocuidadointegral.repository.ProductoRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class MovimientoStockService {

    private final MovimientoStockRepository movimientoStockRepository;
    private final ProductoRepository productoRepository;

    public MovimientoStockService(MovimientoStockRepository movimientoStockRepository,
                                  ProductoRepository productoRepository) {
        this.movimientoStockRepository = movimientoStockRepository;
        this.productoRepository = productoRepository;
    }

    public List<MovimientoStock> listarTodos() {
        return movimientoStockRepository.findAll();
    }

    public List<MovimientoStock> listarPorProducto(Long idProducto) {
        return movimientoStockRepository.findByProductoIdProducto(idProducto);
    }

    @Transactional
    public MovimientoStock registrarMovimiento(Long idProducto, String tipo,
                                               Integer cantidad, String motivo) {
        Producto producto = productoRepository.findById(idProducto)
                .orElseThrow(() -> new RuntimeException("Producto no encontrado"));
        MovimientoStock movimiento = new MovimientoStock();
        movimiento.setProducto(producto);
        movimiento.setTipo(tipo);
        movimiento.setCantidad(cantidad);
        movimiento.setFecha(LocalDateTime.now());
        movimiento.setMotivo(motivo);
        return movimientoStockRepository.save(movimiento);
    }
}
