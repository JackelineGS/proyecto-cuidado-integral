package com.argos.proyectocuidadointegral.observer;

import com.argos.proyectocuidadointegral.model.Producto;
import org.springframework.stereotype.Component;
import java.util.ArrayList;
import java.util.List;

@Component
public class ProductoEventPublisher {

    private final List<ProductoObserver> observers = new ArrayList<>();

    public void suscribir(ProductoObserver observer) {
        observers.add(observer);
    }

    public void notificar(Producto producto) {
        for (ProductoObserver observer : observers) {
            observer.onProductoActualizado(producto);
        }
    }
}
