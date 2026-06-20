package com.argos.proyectocuidadointegral.observer;

import com.argos.proyectocuidadointegral.model.Producto;
import org.springframework.stereotype.Component;

@Component
public class StockBajoObserver implements ProductoObserver {

    @Override
    public void onProductoActualizado(Producto producto) {
        if (producto.getStock() != null && producto.getStockMinimo() != null
                && producto.getStock() <= producto.getStockMinimo()) {
            System.out.println("[ALERTA] Stock bajo para producto: "
                    + producto.getNombre() + " | Stock actual: " + producto.getStock());
        }
    }
}
+