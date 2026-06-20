package com.argos.proyectocuidadointegral.controller;

import com.argos.proyectocuidadointegral.service.MovimientoStockService;
import com.argos.proyectocuidadointegral.service.ProductoService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class MovimientoStockController {

    private final MovimientoStockService movimientoStockService;
    private final ProductoService productoService;

    public MovimientoStockController(MovimientoStockService movimientoStockService,
                                     ProductoService productoService) {
        this.movimientoStockService = movimientoStockService;
        this.productoService = productoService;
    }

    @GetMapping("/stock/movimientos")
    public String listarMovimientos(Model model) {
        model.addAttribute("movimientos", movimientoStockService.listarTodos());
        return "stock/movimientos";
    }

    @GetMapping("/stock/movimientos/{idProducto}")
    public String movimientosPorProducto(@PathVariable Long idProducto, Model model) {
        model.addAttribute("movimientos", movimientoStockService.listarPorProducto(idProducto));
        productoService.buscarPorId(idProducto).ifPresent(p -> model.addAttribute("producto", p));
        return "stock/movimientos";
    }

    @PostMapping("/stock/ajustar")
    public String ajustarStock(@RequestParam Long idProducto,
                               @RequestParam String tipo,
                               @RequestParam Integer cantidad,
                               @RequestParam String motivo) {
        movimientoStockService.registrarMovimiento(idProducto, tipo, cantidad, motivo);
        productoService.actualizarStock(idProducto, cantidad, tipo);
        return "redirect:/productos";
    }
}
