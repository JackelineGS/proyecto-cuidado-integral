package com.argos.proyectocuidadointegral.controller;

import com.argos.proyectocuidadointegral.service.CarritoService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class CarritoController {

    private final CarritoService carritoService;

    public CarritoController(CarritoService carritoService) {
        this.carritoService = carritoService;
    }

    @GetMapping("/carrito")
    public String verCarrito(Model model) {
        model.addAttribute("carrito", carritoService.getCarrito());
        model.addAttribute("total", carritoService.calcularTotal());
        return "carrito/vista";
    }

    @PostMapping("/carrito/agregar")
    public String agregar(@RequestParam Long idProducto, @RequestParam int cantidad) {
        carritoService.agregarProducto(idProducto, cantidad);
        return "redirect:/carrito";
    }

    @PostMapping("/carrito/quitar")
    public String quitar(@RequestParam Long idProducto) {
        carritoService.quitarProducto(idProducto);
        return "redirect:/carrito";
    }


    @PostMapping("/carrito/vaciar")
    public String vaciar() {
        carritoService.vaciar();
        return "redirect:/carrito";
    }
}
