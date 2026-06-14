package com.argos.proyectocuidadointegral.service;

import com.argos.proyectocuidadointegral.dto.SolicitudAdopcionDTO;
import com.argos.proyectocuidadointegral.model.MascotaRescatada;
import com.argos.proyectocuidadointegral.model.SolicitudAdopcion;
import com.argos.proyectocuidadointegral.repository.MascotaRescatadaRepository;
import com.argos.proyectocuidadointegral.repository.SolicitudAdopcionRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class AdopcionService {

    private final MascotaRescatadaRepository mascotaRescatadaRepository;
    private final SolicitudAdopcionRepository solicitudAdopcionRepository;

    public static final Map<String, String> STATUS_LABELS = Map.of(
            "pendiente", "Pendiente",
            "en_evaluacion", "En evaluación",
            "confirmado", "Confirmado",
            "rechazado", "Rechazado",
            "finalizado", "Finalizado"
    );

    public static final Map<String, String> STATUS_STYLES = Map.of(
            "pendiente", "bg-[#fff4e5] text-[#b9770e]",
            "en_evaluacion", "bg-[#e8f0fe] text-[#1a56db]",
            "confirmado", "bg-[#e1f5ee] text-[#085041]",
            "rechazado", "bg-[#faece7] text-[#d85a30]",
            "finalizado", "bg-[#f7f3ee] text-[#5f5e5a]"
    );

    public AdopcionService(MascotaRescatadaRepository mascotaRescatadaRepository,
                            SolicitudAdopcionRepository solicitudAdopcionRepository) {
        this.mascotaRescatadaRepository = mascotaRescatadaRepository;
        this.solicitudAdopcionRepository = solicitudAdopcionRepository;
    }


    public List<MascotaRescatada> listarTodas() {
        return mascotaRescatadaRepository.findAll();
    }

    public Optional<MascotaRescatada> buscarPorId(Integer id) {
        return mascotaRescatadaRepository.findById(id);
    }

    public MascotaRescatada guardar(MascotaRescatada mascota) {
        if (mascota.getEstado() == null || mascota.getEstado().isBlank()) {
            mascota.setEstado("disponible");
        }
        return mascotaRescatadaRepository.save(mascota);
    }

    public void eliminar(Integer id) {
        mascotaRescatadaRepository.deleteById(id);
    }

    public long contarTotal() {
        return mascotaRescatadaRepository.count();
    }

    public long contarDisponibles() {
        return mascotaRescatadaRepository.findByEstado("disponible").size();
    }


    public List<SolicitudAdopcion> listarSolicitudes() {
        return solicitudAdopcionRepository.findAllByOrderByCreatedAtDesc();
    }

    public long contarNoLeidas() {
        return solicitudAdopcionRepository.countByReadFalse();
    }

    public void marcarLeido(Integer id) {
        solicitudAdopcionRepository.findById(id).ifPresent(solicitud -> {
            solicitud.setRead(true);
            solicitudAdopcionRepository.save(solicitud);
        });
    }

    public void cambiarEstadoSolicitud(Integer id, String nuevoEstado) {
        solicitudAdopcionRepository.findById(id).ifPresent(solicitud -> {
            solicitud.setRequestStatus(nuevoEstado);
            solicitudAdopcionRepository.save(solicitud);
        });
    }

    public void crearSolicitud(SolicitudAdopcionDTO dto) {
        MascotaRescatada mascota = mascotaRescatadaRepository.findById(dto.getIdMascota())
                .orElseThrow(() -> new IllegalArgumentException("Mascota no encontrada: " + dto.getIdMascota()));

        SolicitudAdopcion solicitud = new SolicitudAdopcion();
        solicitud.setApplicantName(dto.getApplicantName());
        solicitud.setEmail(dto.getEmail());
        solicitud.setPhone(dto.getPhone());
        solicitud.setDistrict(dto.getDistrict());
        solicitud.setMascotaRescatada(mascota);
        solicitud.setRequestStatus("pendiente");
        solicitud.setRead(false);
        solicitud.setCreatedAt(LocalDateTime.now());

        solicitudAdopcionRepository.save(solicitud);
    }
}