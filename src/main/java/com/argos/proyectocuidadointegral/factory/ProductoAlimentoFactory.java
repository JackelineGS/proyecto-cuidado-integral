package com.argos.proyectocuidadointegral.factory;

import com.argos.proyectocuidadointegral.enums.CategoriaProducto;
import com.argos.proyectocuidadointegral.enums.UnidadMedida;
import com.argos.proyectocuidadointegral.model.Producto;
import org.springframework.stereotype.Component;

@Component
public class ProductoAlimentoFactory extends ProductoFactory {

    @Override
    protected void configurar(Producto producto) {
        producto.setCategoria(CategoriaProducto.ALIMENTO);
        producto.setUnidadMedida(UnidadMedida.KILOGRAMO);
        producto.setDescripcion("Alimento balanceado para mascotas");
    }
}
