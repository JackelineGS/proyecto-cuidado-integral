package com.argos.proyectocuidadointegral.controller;

import com.argos.proyectocuidadointegral.dto.SolicitudAdopcionDTO;
import com.argos.proyectocuidadointegral.model.MascotaRescatada;
import com.argos.proyectocuidadointegral.service.AdopcionService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/adopciones")
public class AdopcionController {

    private final AdopcionService adopcionService;

    public AdopcionController(AdopcionService adopcionService) {
        this.adopcionService = adopcionService;
    }

    @GetMapping
    public String verAdopciones(
            @RequestParam(value = "action", required = false) String action,
            @RequestParam(value = "id", required = false) Integer id,
            Model model) {

        boolean showForm = "nuevo".equals(action) || "editar".equals(action);
        boolean showSolicitudForm = "nueva-solicitud".equals(action);

        model.addAttribute("showForm", showForm);
        model.addAttribute("showSolicitudForm", showSolicitudForm);

        if ("editar".equals(action) && id != null) {
            MascotaRescatada mascota = adopcionService.buscarPorId(id)
                    .orElseThrow(() -> new IllegalArgumentException("Mascota no encontrada: " + id));
            model.addAttribute("mascotaAdopcion", mascota);
        } else {
            model.addAttribute("mascotaAdopcion", new MascotaRescatada());
        }

        model.addAttribute("nuevaSolicitud", new SolicitudAdopcionDTO()); // siempre

        model.addAttribute("adoptionPets", adopcionService.listarTodas());
        model.addAttribute("adoptionRequests", adopcionService.listarSolicitudes());
        model.addAttribute("unreadCount", adopcionService.contarNoLeidas());
        model.addAttribute("statusLabelsMap", AdopcionService.STATUS_LABELS);
        model.addAttribute("statusStylesMap", AdopcionService.STATUS_STYLES);

        return "adopciones/lista";
    }

    // Guardar (nueva mascota o edición, según traiga id)
    @PostMapping("/mascota/guardar")
    public String guardarMascota(@ModelAttribute("mascotaAdopcion") MascotaRescatada mascota) {
        adopcionService.guardar(mascota);
        return "redirect:/adopciones";
    }

    // Eliminar mascota
    @GetMapping("/eliminar/{id}")
    public String eliminar(@PathVariable Integer id) {
        adopcionService.eliminar(id);
        return "redirect:/adopciones";
    }


    // Guardar nueva solicitud 
    @PostMapping("/solicitud/guardar")
    public String guardarSolicitud(@ModelAttribute("nuevaSolicitud") SolicitudAdopcionDTO dto) {
        adopcionService.crearSolicitud(dto);
        return "redirect:/adopciones?tab=requests";
    }


    @PostMapping("/api/marcar-leido/{id}")
    @ResponseBody
    public ResponseEntity<Void> marcarLeido(@PathVariable Integer id) {
        adopcionService.marcarLeido(id);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/api/cambiar-estado/{id}")
    @ResponseBody
    public ResponseEntity<Void> cambiarEstado(@PathVariable Integer id,
                                               @RequestParam("status") String status) {
        adopcionService.cambiarEstadoSolicitud(id, status);
        return ResponseEntity.ok().build();
    }
}