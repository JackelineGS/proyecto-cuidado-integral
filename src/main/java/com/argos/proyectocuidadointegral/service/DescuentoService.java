package com.argos.proyectocuidadointegral.service;

import com.argos.proyectocuidadointegral.model.Descuento;
import com.argos.proyectocuidadointegral.repository.DescuentoRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class DescuentoService {

    private final DescuentoRepository descuentoRepository;

    public DescuentoService(DescuentoRepository descuentoRepository) {
        this.descuentoRepository = descuentoRepository;
    }

    public List<Descuento> listarActivos() {
        return descuentoRepository.findByActivoTrue();
    }

    public Optional<Descuento> buscarPorCodigo(String codigo) {
        return descuentoRepository.findByCodigo(codigo);
    }

    public Double aplicarDescuento(String codigo, Double precioOriginal) {
        Optional<Descuento> descuentoOpt = descuentoRepository.findByCodigo(codigo);
        if (descuentoOpt.isEmpty()) return precioOriginal;
        Descuento descuento = descuentoOpt.get();
        LocalDate hoy = LocalDate.now();
        boolean vigente = !hoy.isBefore(descuento.getFechaInicio())
                && !hoy.isAfter(descuento.getFechaFin())
                && Boolean.TRUE.equals(descuento.getActivo());
        if (!vigente) return precioOriginal;
        return precioOriginal * (1 - descuento.getPorcentaje() / 100.0);
    }

    @Transactional
    public Descuento guardar(Descuento descuento) {
        return descuentoRepository.save(descuento);
    }

    @Transactional
    public void eliminar(Long id) {
        descuentoRepository.deleteById(id);
    }
}
