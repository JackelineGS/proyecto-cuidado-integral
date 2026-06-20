package com.argos.proyectocuidadointegral.factory;

import com.argos.proyectocuidadointegral.enums.CategoriaProducto;
import com.argos.proyectocuidadointegral.enums.UnidadMedida;
import com.argos.proyectocuidadointegral.model.Producto;
import org.springframework.stereotype.Component;

@Component
public class ProductoAccesorioFactory extends ProductoFactory {

    @Override
    protected void configurar(Producto producto) {
        producto.setCategoria(CategoriaProducto.ACCESORIO);
        producto.setUnidadMedida(UnidadMedida.UNIDAD);
        producto.setDescripcion("Accesorio para el cuidado de mascotas");
    }
}
