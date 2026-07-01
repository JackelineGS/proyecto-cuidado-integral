package com.argos.proyectocuidadointegral.service;

import com.argos.proyectocuidadointegral.dto.CitaDTO;
import com.argos.proyectocuidadointegral.model.Cita;
import com.argos.proyectocuidadointegral.repository.AtencionMedicaRepository;
import com.argos.proyectocuidadointegral.repository.CitaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CitaService {

    private final CitaRepository citaRepository;
    private final AtencionMedicaRepository atencionRepository;

    public CitaService(CitaRepository citaRepository, AtencionMedicaRepository atencionRepository) {
        this.citaRepository = citaRepository;
        this.atencionRepository = atencionRepository;
    }

    public List<CitaDTO> listarCitasDashboard() {
        return citaRepository.findAll().stream()
                .map(this::convertirADTO)
                .collect(Collectors.toList());
    }

    private CitaDTO convertirADTO(Cita cita) {
        CitaDTO dto = new CitaDTO();
        dto.setId(cita.getId());
        dto.setFecha(cita.getFecha());
        //dto.setHora(cita.getHora());
        dto.setStatus(cita.getEstado().name());
        dto.setMotivoConsulta(cita.getMotivoConsulta());

        if (cita.getEstado() != null) {
            dto.setStatus(cita.getEstado().name());
        } else {
            dto.setStatus("PENDIENTE");
        }

        if (cita.getCliente() != null) {
            dto.setClienteDni(cita.getCliente().getDni());
            dto.setClienteNombre(cita.getCliente().getNombre());
        }
        if (cita.getPaciente() != null) {
            dto.setPacienteNombre(cita.getPaciente().getName());
        }
        if (cita.getVeterinario() != null) {
            dto.setDoctor(cita.getVeterinario().getNombre());
        }

        boolean existeAtencion = atencionRepository.existsByCitaId(cita.getId());
        dto.setTieneHistorialMedico(existeAtencion);

        return dto;
    }
}
