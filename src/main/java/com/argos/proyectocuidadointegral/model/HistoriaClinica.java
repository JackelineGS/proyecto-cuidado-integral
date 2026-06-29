package com.argos.proyectocuidadointegral.model;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;
@Entity
@Table(name = "historia_clinica")
public class HistoriaClinica {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_historia")
    private Integer id;

    @OneToOne  // Relación OneToOne con Paciente
    @JoinColumn(name = "id_paciente", nullable = false)
    private Paciente paciente;

    // Una Historia Clínica tiene muchos Atenciones
    @OneToMany(mappedBy = "historiaClinica", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<AtencionMedica> atenciones = new ArrayList<>();

    public HistoriaClinica() {}

    // Getters y Setters
    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }
    public Paciente getPaciente() { return paciente; }
    public void setPaciente(Paciente paciente) { this.paciente = paciente; }
    public List<AtencionMedica> getAtenciones() { return atenciones; }
    public void setAtenciones(List<AtencionMedica> atenciones) { this.atenciones = atenciones; }
}

