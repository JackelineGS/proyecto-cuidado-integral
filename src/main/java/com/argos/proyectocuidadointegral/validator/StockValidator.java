package com.argos.proyectocuidadointegral.validator;

import com.argos.proyectocuidadointegral.model.Producto;
import org.springframework.stereotype.Component;

@Component
public class StockValidator {

    public boolean tieneSuficienteStock(Producto producto, int cantidadSolicitada) {
        return producto.getStock() != null && producto.getStock() >= cantidadSolicitada;
    }

    public boolean estaEnStockBajo(Producto producto) {
        return producto.getStock() != null
                && producto.getStockMinimo() != null
                && producto.getStock() <= producto.getStockMinimo();
    }

    public boolean estaAgotado(Producto producto) {
        return producto.getStock() != null && producto.getStock() == 0;
    }
}
