package com.argos.proyectocuidadointegral.controller;

import com.argos.proyectocuidadointegral.enums.CategoriaProducto;
import com.argos.proyectocuidadointegral.enums.EstadoProducto;
import com.argos.proyectocuidadointegral.enums.UnidadMedida;
import com.argos.proyectocuidadointegral.model.Producto;
import com.argos.proyectocuidadointegral.service.ProductoService;
import com.argos.proyectocuidadointegral.service.ProveedorService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@Controller
public class ProductoController {

    private final ProductoService productoService;
    private final ProveedorService proveedorService;


    public ProductoController(ProductoService productoService, ProveedorService proveedorService) {
        this.productoService = productoService;
        this.proveedorService = proveedorService;
    }

    @GetMapping("/productos")
    public String listarProductos(
            @RequestParam(required = false) String searchTerm,
            @RequestParam(required = false) String categoriaFilter,
            @RequestParam(required = false) String action,
            @RequestParam(required = false) Long id,
            Model model) {

        List<Producto> productos;
        if (searchTerm != null && !searchTerm.isBlank()) {
            productos = productoService.buscarPorNombre(searchTerm);
        } else if (categoriaFilter != null && !categoriaFilter.equals("Todos")) {
            productos = productoService.buscarPorCategoria(CategoriaProducto.valueOf(categoriaFilter));
        } else {
            productos = productoService.listarTodos();
        }

        boolean showForm = "nuevo".equals(action) || ("editar".equals(action) && id != null);
        Producto productoForm = new Producto();
        if ("editar".equals(action) && id != null) {
            productoForm = productoService.buscarPorId(id).orElse(new Producto());
        }

        model.addAttribute("productos", productos);
        model.addAttribute("producto", productoForm);
        model.addAttribute("showForm", showForm);
        model.addAttribute("searchTerm", searchTerm);
        model.addAttribute("categoriaFilter", categoriaFilter);
        model.addAttribute("categorias", CategoriaProducto.values());
        model.addAttribute("estados", EstadoProducto.values());
        model.addAttribute("unidades", UnidadMedida.values());
        model.addAttribute("proveedores", proveedorService.listarTodos());
        return "productos/lista";
    }

    @PostMapping("/productos/guardar")
    public String guardarProducto(@ModelAttribute("producto") Producto producto,
                                  @RequestParam(required = false) Long proveedorId) {
        if (proveedorId != null) {
            proveedorService.buscarPorId(proveedorId).ifPresent(producto::setProveedor);
        }
        productoService.guardar(producto);
        return "redirect:/productos";
    }

    @GetMapping("/productos/eliminar/{id}")
    public String eliminarProducto(@PathVariable Long id) {
        productoService.eliminar(id);
        return "redirect:/productos";
    }

    @GetMapping("/productos/stock-bajo")
    public String listarStockBajo(Model model) {
        model.addAttribute("productos", productoService.listarStockBajo());
        return "productos/stock-bajo";
    }
}
