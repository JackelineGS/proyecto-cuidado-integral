package com.argos.proyectocuidadointegral.util;

import com.argos.proyectocuidadointegral.model.DetalleOrden;
import java.util.List;

public class OrdenUtil {

    private OrdenUtil() {}

    public static double calcularTotal(List<DetalleOrden> detalles) {
        if (detalles == null) return 0.0;
        return detalles.stream()
                .mapToDouble(d -> d.getPrecioUnitario() * d.getCantidad())
                .sum();
    }

    public static String etiquetaEstado(String estado) {
        if (estado == null) return "Desconocido";
        return switch (estado) {
            case "PENDIENTE" -> "Pendiente";
            case "CONFIRMADA" -> "Confirmada";
            case "CANCELADA" -> "Cancelada";
            default -> estado;
        };
    }
}
