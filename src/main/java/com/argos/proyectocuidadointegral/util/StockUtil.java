package com.argos.proyectocuidadointegral.util;

import com.argos.proyectocuidadointegral.model.Producto;

public class StockUtil {

    private StockUtil() {}

    public static boolean esStockCritico(Producto producto) {
        return producto.getStock() != null
                && producto.getStockMinimo() != null
                && producto.getStock() <= producto.getStockMinimo();
    }

    public static String etiquetaStock(Producto producto) {
        if (producto.getStock() == null || producto.getStock() == 0) return "Agotado";
        if (esStockCritico(producto)) return "Stock bajo";
        return "Disponible";
    }
}
