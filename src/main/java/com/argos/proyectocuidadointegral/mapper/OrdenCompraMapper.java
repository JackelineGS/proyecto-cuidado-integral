package com.argos.proyectocuidadointegral.mapper;

import com.argos.proyectocuidadointegral.dto.DetalleOrdenDTO;
import com.argos.proyectocuidadointegral.dto.OrdenCompraDTO;
import com.argos.proyectocuidadointegral.model.OrdenCompra;
import org.springframework.stereotype.Component;
import java.util.stream.Collectors;

@Component
public class OrdenCompraMapper {

    public OrdenCompraDTO toDTO(OrdenCompra orden) {
        OrdenCompraDTO dto = new OrdenCompraDTO();
        dto.setIdOrden(orden.getIdOrden());
        dto.setFechaOrden(orden.getFechaOrden());
        dto.setTotal(orden.getTotal());
        dto.setEstado(orden.getEstado());
        if (orden.getCliente() != null) {
            dto.setNombreCliente(orden.getCliente().getNombre());
        }
        if (orden.getDetalles() != null) {
            dto.setDetalles(orden.getDetalles().stream().map(d -> {
                DetalleOrdenDTO det = new DetalleOrdenDTO();
                det.setIdDetalle(d.getIdDetalle());
                det.setCantidad(d.getCantidad());
                det.setPrecioUnitario(d.getPrecioUnitario());
                det.setSubtotal(d.getSubtotal());
                if (d.getProducto() != null) {
                    det.setIdProducto(d.getProducto().getIdProducto());
                    det.setNombreProducto(d.getProducto().getNombre());
                }
                return det;
            }).collect(Collectors.toList()));
        }
        return dto;
    }
}
