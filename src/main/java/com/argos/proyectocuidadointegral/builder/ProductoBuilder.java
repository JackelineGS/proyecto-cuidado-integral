package com.argos.proyectocuidadointegral.builder;

import com.argos.proyectocuidadointegral.enums.CategoriaProducto;
import com.argos.proyectocuidadointegral.enums.EstadoProducto;
import com.argos.proyectocuidadointegral.enums.UnidadMedida;
import com.argos.proyectocuidadointegral.model.Producto;

public class ProductoBuilder {

    private final Producto producto;

    public ProductoBuilder() {
        this.producto = new Producto();
    }

    public ProductoBuilder nombre(String nombre) {
        producto.setNombre(nombre);
        return this;
    }

    public ProductoBuilder descripcion(String descripcion) {
        producto.setDescripcion(descripcion);
        return this;
    }

    public ProductoBuilder precio(Double precio) {
        producto.setPrecio(precio);
        return this;
    }

    public ProductoBuilder stock(Integer stock) {
        producto.setStock(stock);
        return this;
    }

    public ProductoBuilder stockMinimo(Integer stockMinimo) {
        producto.setStockMinimo(stockMinimo);
        return this;
    }

    public ProductoBuilder categoria(CategoriaProducto categoria) {
        producto.setCategoria(categoria);
        return this;
    }

    public ProductoBuilder estado(EstadoProducto estado) {
        producto.setEstado(estado);
        return this;
    }

    public ProductoBuilder unidadMedida(UnidadMedida unidadMedida) {
        producto.setUnidadMedida(unidadMedida);
        return this;
    }

    public ProductoBuilder imagenUrl(String imagenUrl) {
        producto.setImagenUrl(imagenUrl);
        return this;
    }

    public Producto build() {
        return producto;
    }
}
