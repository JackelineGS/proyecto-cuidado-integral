package com.argos.proyectocuidadointegral.strategy;

import com.argos.proyectocuidadointegral.model.Producto;

public interface PrecioStrategy {
    double calcularPrecio(Producto producto);
}
