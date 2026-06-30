package com.argos.proyectocuidadointegral.strategy;

import com.argos.proyectocuidadointegral.model.Producto;
import org.springframework.stereotype.Component;

@Component
public class PrecioNormalStrategy implements PrecioStrategy {

    @Override
    public double calcularPrecio(Producto producto) {
        return producto.getPrecio();
    }
}
