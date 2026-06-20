package com.argos.proyectocuidadointegral.controller;

import com.argos.proyectocuidadointegral.model.OrdenCompra;
import com.argos.proyectocuidadointegral.service.OrdenCompraService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@Controller
public class OrdenCompraController {

    private final OrdenCompraService ordenCompraService;

    public OrdenCompraController(OrdenCompraService ordenCompraService) {
        this.ordenCompraService = ordenCompraService;
    }

    @GetMapping("/ordenes")
    public String listarOrdenes(Model model) {
        List<OrdenCompra> ordenes = ordenCompraService.listarTodas();
        model.addAttribute("ordenes", ordenes);
        return "ordenes/lista";
    }

    @GetMapping("/ordenes/{id}")
    public String detalleOrden(@PathVariable Long id, Model model) {
        ordenCompraService.buscarPorId(id).ifPresent(o -> model.addAttribute("orden", o));
        return "ordenes/detalle";
    }

    @PostMapping("/ordenes/{id}/confirmar")
    public String confirmarOrden(@PathVariable Long id) {
        ordenCompraService.confirmarOrden(id);
        return "redirect:/ordenes";
    }

    @PostMapping("/ordenes/{id}/cancelar")
    public String cancelarOrden(@PathVariable Long id) {
        ordenCompraService.cancelarOrden(id);
        return "redirect:/ordenes";
    }
}
