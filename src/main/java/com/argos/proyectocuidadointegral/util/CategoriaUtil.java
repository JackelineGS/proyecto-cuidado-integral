package com.argos.proyectocuidadointegral.util;

import com.argos.proyectocuidadointegral.enums.CategoriaProducto;

public class CategoriaUtil {

    private CategoriaUtil() {}

    public static String etiqueta(CategoriaProducto categoria) {
        if (categoria == null) return "Sin categoría";
        return switch (categoria) {
            case ALIMENTO -> "Alimento";
            case ACCESORIO -> "Accesorio";
            case MEDICAMENTO -> "Medicamento";
            case HIGIENE -> "Higiene";
            case JUGUETE -> "Juguete";
            case ROPA -> "Ropa";
            case CAMA -> "Cama";
            case TRANSPORTADORA -> "Transportadora";
        };
    }
}
