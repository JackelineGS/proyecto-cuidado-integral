package com.argos.proyectocuidadointegral.util;

public class PrecioUtil {

    private PrecioUtil() {}

    public static double aplicarDescuento(double precio, double porcentaje) {
        return precio * (1 - porcentaje / 100.0);
    }

    public static double redondear(double valor) {
        return Math.round(valor * 100.0) / 100.0;
    }

    public static String formatear(double precio) {
        return String.format("S/ %.2f", precio);
    }
}
