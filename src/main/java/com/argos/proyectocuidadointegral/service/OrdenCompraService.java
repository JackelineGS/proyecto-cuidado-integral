package com.argos.proyectocuidadointegral.service;

import com.argos.proyectocuidadointegral.dto.DetalleOrdenDTO;
import com.argos.proyectocuidadointegral.dto.OrdenCompraDTO;
import com.argos.proyectocuidadointegral.model.DetalleOrden;
import com.argos.proyectocuidadointegral.model.OrdenCompra;
import com.argos.proyectocuidadointegral.repository.OrdenCompraRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class OrdenCompraService {

    private final OrdenCompraRepository ordenCompraRepository;
    private final ProductoService productoService;

    public OrdenCompraService(OrdenCompraRepository ordenCompraRepository,
                              ProductoService productoService) {
        this.ordenCompraRepository = ordenCompraRepository;
        this.productoService = productoService;
    }

    // Retorna las entidades puras (útil para lógica interna del backend)
    public List<OrdenCompra> listarTodas() {
        return ordenCompraRepository.findAll();
    }

    // NUEVO MÉTODO: Retorna la lista transformada a DTOs lista para el Dashboard
    public List<OrdenCompraDTO> listarTodasMapeadas() {
        return ordenCompraRepository.findAll().stream()
                .map(this::convertirADTO)
                .collect(Collectors.toList());
    }

    public Optional<OrdenCompra> buscarPorId(Integer id) {
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
    public void confirmarOrden(Integer idOrden) {
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
    public void cancelarOrden(Integer idOrden) {
        OrdenCompra orden = ordenCompraRepository.findById(idOrden)
                .orElseThrow(() -> new RuntimeException("Orden no encontrada"));
        orden.setEstado("CANCELADA");
        ordenCompraRepository.save(orden);
    }

    // MÉTODO PRIVADO AUXILIAR: Se encarga de la conversión de Entidad -> DTO
    private OrdenCompraDTO convertirADTO(OrdenCompra orden) {
        OrdenCompraDTO dto = new OrdenCompraDTO();
        dto.setIdOrden(orden.getIdOrden());
        dto.setFechaOrden(orden.getFechaOrden());
        dto.setTotal(orden.getTotal());
        dto.setEstado(orden.getEstado());

        // Mapear Nombre del Cliente (ajusta getNombre() si tu entidad usa otro getter)
        if (orden.getCliente() != null) {
            dto.setNombreCliente(orden.getCliente().getNombre());
        }

        // Mapear Lista de Detalles de la Orden
        if (orden.getDetalles() != null) {
            List<DetalleOrdenDTO> detallesDTO = orden.getDetalles().stream()
                    .map(detalle -> {
                        DetalleOrdenDTO dDto = new DetalleOrdenDTO();
                        dDto.setCantidad(detalle.getCantidad());
                        // Ajusta los getters de Producto según tu entidad real
                        if (detalle.getProducto() != null) {
                            dDto.setNombreProducto(detalle.getProducto().getNombre());
                        }
                        return dDto;
                    }).collect(Collectors.toList());
            dto.setDetalles(detallesDTO);
        } else {
            dto.setDetalles(new ArrayList<>());
        }

        return dto;
    }
}