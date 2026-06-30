package com.argos.proyectocuidadointegral.exception;

public class ProductoNotFoundException extends RuntimeException {

    public ProductoNotFoundException(Integer id) {
        super("Producto no encontrado con id: " + id);
    }


    public ProductoNotFoundException(String mensaje) {
        super(mensaje);
    }
}
