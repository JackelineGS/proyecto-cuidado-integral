package com.argos.proyectocuidadointegral.service;

import com.argos.proyectocuidadointegral.model.DetalleOrden;
import com.argos.proyectocuidadointegral.model.OrdenCompra;
import com.argos.proyectocuidadointegral.repository.OrdenCompraRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class OrdenCompraService {

    private final OrdenCompraRepository ordenCompraRepository;
    private final ProductoService productoService;

    public OrdenCompraService(OrdenCompraRepository ordenCompraRepository,
                              ProductoService productoService) {
        this.ordenCompraRepository = ordenCompraRepository;
        this.productoService = productoService;
    }

    public List<OrdenCompra> listarTodas() {
        return ordenCompraRepository.findAll();
    }

    public Optional<OrdenCompra> buscarPorId(Long id) {
        return ordenCompraRepository.findById(id);
    }

    @Transactional
    public OrdenCompra crearOrden(OrdenCompra orden) {
        orden.setFechaOrden(LocalDateTime.now());
        orden.setEstado("PENDIENTE");
        double total = 0.0;
        for (DetalleOrden detalle : orden.getDetalles()) {
            detalle.setOrdenCompra(orden);
            double subtotal = detalle.getPrecioUnitario() * detalle.getCantidad();
            detalle.setSubtotal(subtotal);
            total += subtotal;
        }
        orden.setTotal(total);
        return ordenCompraRepository.save(orden);
    }

    @Transactional
    public void confirmarOrden(Long idOrden) {
        OrdenCompra orden = ordenCompraRepository.findById(idOrden)
                .orElseThrow(() -> new RuntimeException("Orden no encontrada"));
        for (DetalleOrden detalle : orden.getDetalles()) {
            productoService.actualizarStock(
                    detalle.getProducto().getIdProducto(),
                    detalle.getCantidad(), "SALIDA");
        }
        orden.setEstado("CONFIRMADA");
        ordenCompraRepository.save(orden);
    }

    @Transactional
    public void cancelarOrden(Long idOrden) {
        OrdenCompra orden = ordenCompraRepository.findById(idOrden)
                .orElseThrow(() -> new RuntimeException("Orden no encontrada"));
        orden.setEstado("CANCELADA");
        ordenCompraRepository.save(orden);
    }
}
