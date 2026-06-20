package com.argos.proyectocuidadointegral.builder;

import com.argos.proyectocuidadointegral.model.Cliente;
import com.argos.proyectocuidadointegral.model.DetalleOrden;
import com.argos.proyectocuidadointegral.model.OrdenCompra;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class OrdenCompraBuilder {

    private final OrdenCompra orden;
    private final List<DetalleOrden> detalles;

    public OrdenCompraBuilder() {
        this.orden = new OrdenCompra();
        this.detalles = new ArrayList<>();
        this.orden.setFechaOrden(LocalDateTime.now());
        this.orden.setEstado("PENDIENTE");
    }

    public OrdenCompraBuilder cliente(Cliente cliente) {
        orden.setCliente(cliente);
        return this;
    }

    public OrdenCompraBuilder agregarDetalle(DetalleOrden detalle) {
        detalles.add(detalle);
        return this;
    }

    public OrdenCompra build() {
        orden.setDetalles(detalles);
        double total = detalles.stream()
                .mapToDouble(d -> d.getPrecioUnitario() * d.getCantidad())
                .sum();
        orden.setTotal(total);
        return orden;
    }
}
