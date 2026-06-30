package com.argos.proyectocuidadointegral.exception;

public class StockInsuficienteException extends RuntimeException {


    public StockInsuficienteException(String nombreProducto, int stockActual, int cantidadSolicitada) {
        super("Stock insuficiente para '" + nombreProducto + "'. Disponible: "
                + stockActual + ", solicitado: " + cantidadSolicitada);
    }
}
