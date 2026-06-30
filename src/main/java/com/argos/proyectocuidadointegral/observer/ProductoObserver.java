package com.argos.proyectocuidadointegral.observer;

import com.argos.proyectocuidadointegral.model.Producto;

public interface ProductoObserver {
    void onProductoActualizado(Producto producto);
}
