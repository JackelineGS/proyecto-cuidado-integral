package com.argos.proyectocuidadointegral.service;

import com.argos.proyectocuidadointegral.model.Producto;
import com.argos.proyectocuidadointegral.repository.ProductoRepository;
import org.springframework.stereotype.Service;
import java.util.HashMap;
import java.util.Map;

@Service
public class CarritoService {

    private final ProductoRepository productoRepository;
    private final Map<Long, Integer> carrito = new HashMap<>();

    public CarritoService(ProductoRepository productoRepository) {
        this.productoRepository = productoRepository;
    }

    public void agregarProducto(Long idProducto, int cantidad) {
        carrito.merge(idProducto, cantidad, Integer::sum);
    }

    public void quitarProducto(Long idProducto) {
        carrito.remove(idProducto);
    }

    public void actualizarCantidad(Long idProducto, int cantidad) {
        if (cantidad <= 0) {
            carrito.remove(idProducto);
        } else {
            carrito.put(idProducto, cantidad);
        }
    }

    public Map<Long, Integer> getCarrito() {
        return carrito;
    }

    public double calcularTotal() {
        double total = 0.0;
        for (Map.Entry<Long, Integer> entry : carrito.entrySet()) {
            Producto p = productoRepository.findById(entry.getKey()).orElse(null);
            if (p != null) {
                total += p.getPrecio() * entry.getValue();
            }
        }
        return total;
    }

    public void vaciar() {
        carrito.clear();
    }
}
