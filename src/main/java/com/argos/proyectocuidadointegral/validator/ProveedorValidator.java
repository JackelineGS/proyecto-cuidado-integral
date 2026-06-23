package com.argos.proyectocuidadointegral.validator;

import com.argos.proyectocuidadointegral.model.Proveedor;
import org.springframework.stereotype.Component;
import java.util.ArrayList;
import java.util.List;

@Component
public class ProveedorValidator {

    public List<String> validar(Proveedor proveedor) {
        List<String> errores = new ArrayList<>();
        if (proveedor.getNombre() == null || proveedor.getNombre().isBlank()) {
            errores.add("El nombre del proveedor es obligatorio");
        }
        if (proveedor.getRuc() != null && !proveedor.getRuc().matches("\\d{11}")) {
            errores.add("El RUC debe tener 11 dígitos numéricos");
        }
        if (proveedor.getEmail() != null && !proveedor.getEmail().isBlank()
                && !proveedor.getEmail().matches("^[\\w.-]+@[\\w.-]+\\.[a-zA-Z]{2,}$")) {
            errores.add("El email no tiene un formato válido");
        }
        return errores;
    }

    public boolean esValido(Proveedor proveedor) {
        return validar(proveedor).isEmpty();
    }
}
