package com.argos.proyectocuidadointegral.strategy;

import com.argos.proyectocuidadointegral.model.Producto;
import org.springframework.stereotype.Component;

@Component
public class PrecioDescuentoStrategy implements PrecioStrategy {

    private final double porcentajeDescuento;

    public PrecioDescuentoStrategy(double porcentajeDescuento) {
        this.porcentajeDescuento = porcentajeDescuento;
    }

    @Override
    public double calcularPrecio(Producto producto) {
        return producto.getPrecio() * (1 - porcentajeDescuento / 100.0);
    }
}
