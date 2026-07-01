package com.argos.proyectocuidadointegral.controller;

import com.argos.proyectocuidadointegral.service.CitaService;
import com.argos.proyectocuidadointegral.service.OrdenCompraService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@Controller
public class DashboardController {

    private final OrdenCompraService ordenCompraService;
    private final CitaService citaService;

    public DashboardController(OrdenCompraService ordenCompraService, CitaService citaService) {

        this.ordenCompraService = ordenCompraService;
        this.citaService = citaService;
    }

    @GetMapping("/dashboard")
    public String verDashboard(Model model) {

        // 1. Inicializar listas vacías seguras para evitar que explote el método .size() o #lists.isEmpty
        model.addAttribute("todayAppointments", citaService.listarCitasDashboard());
        model.addAttribute("purchases", ordenCompraService.listarTodasMapeadas());
        model.addAttribute("adoptionRequests", new ArrayList<>());
        // model.addAttribute("purchases", new ArrayList<>());

        // 2. Valores por defecto para los contadores estadísticos de las tarjetas
        model.addAttribute("unreadRequestsCount", 0);
        model.addAttribute("totalPacientes", 0);
        model.addAttribute("totalClientes", 0);
        model.addAttribute("totalCitas", 0);
        model.addAttribute("totalEnAdopcion", 0);

        // 3. 🌟 CRUCIAL: El mapa de traducción que exige tu tabla inferior para el método de pago
        Map<String, String> methodLabels = new HashMap<>();
        methodLabels.put("tarjeta", "Tarjeta de crédito / débito");
        methodLabels.put("transferencia", "Transferencia bancaria");
        methodLabels.put("billetera", "Billetera digital");
        model.addAttribute("methodLabels", methodLabels);

        return "dashboard/index";
    }

}
