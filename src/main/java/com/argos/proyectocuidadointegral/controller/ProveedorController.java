package com.argos.proyectocuidadointegral.controller;

import com.argos.proyectocuidadointegral.model.Proveedor;
import com.argos.proyectocuidadointegral.service.ProveedorService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@Controller
public class ProveedorController {

    private final ProveedorService proveedorService;

    public ProveedorController(ProveedorService proveedorService) {
        this.proveedorService = proveedorService;
    }

    @GetMapping("/proveedores")
    public String listarProveedores(
            @RequestParam(required = false) String searchTerm,
            @RequestParam(required = false) String action,
            @RequestParam(required = false) Long id,
            Model model) {

        List<Proveedor> proveedores = (searchTerm != null && !searchTerm.isBlank())
                ? proveedorService.buscarPorNombre(searchTerm)
                : proveedorService.listarTodos();

        boolean showForm = "nuevo".equals(action) || ("editar".equals(action) && id != null);
        Proveedor proveedorForm = new Proveedor();
        if ("editar".equals(action) && id != null) {
            proveedorForm = proveedorService.buscarPorId(id).orElse(new Proveedor());
        }

        model.addAttribute("proveedores", proveedores);
        model.addAttribute("proveedor", proveedorForm);
        model.addAttribute("showForm", showForm);
        model.addAttribute("searchTerm", searchTerm);
        return "proveedores/lista";
    }

    @PostMapping("/proveedores/guardar")
    public String guardarProveedor(@ModelAttribute("proveedor") Proveedor proveedor) {
        proveedorService.guardar(proveedor);
        return "redirect:/proveedores";
    }

    @GetMapping("/proveedores/eliminar/{id}")
    public String eliminarProveedor(@PathVariable Long id) {
        proveedorService.eliminar(id);
        return "redirect:/proveedores";
    }
}
