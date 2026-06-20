package com.argos.proyectocuidadointegral.factory;

import com.argos.proyectocuidadointegral.enums.CategoriaProducto;
import com.argos.proyectocuidadointegral.enums.EstadoProducto;
import com.argos.proyectocuidadointegral.enums.UnidadMedida;
import com.argos.proyectocuidadointegral.model.Producto;

public abstract class ProductoFactory {

    public Producto crearProducto(String nombre, Double precio, Integer stock) {
        Producto producto = new Producto();
        producto.setNombre(nombre);
        producto.setPrecio(precio);
        producto.setStock(stock);
        producto.setStockMinimo(5);
        producto.setEstado(EstadoProducto.DISPONIBLE);
        configurar(producto);
        return producto;
    }

    protected abstract void configurar(Producto producto);
}
