package com.argos.proyectocuidadointegral.validator;

import com.argos.proyectocuidadointegral.model.Producto;
import org.springframework.stereotype.Component;
import java.util.ArrayList;
import java.util.List;

@Component
public class ProductoValidator {

    public List<String> validar(Producto producto) {
        List<String> errores = new ArrayList<>();
        if (producto.getNombre() == null || producto.getNombre().isBlank()) {
            errores.add("El nombre del producto es obligatorio");
        }
        if (producto.getPrecio() == null || producto.getPrecio() <= 0) {
            errores.add("El precio debe ser mayor a 0");
        }
        if (producto.getStock() == null || producto.getStock() < 0) {
            errores.add("El stock no puede ser negativo");
        }
        if (producto.getCategoria() == null) {
            errores.add("La categoría es obligatoria");
        }
        return errores;
    }

    public boolean esValido(Producto producto) {
        return validar(producto).isEmpty();
    }
}
