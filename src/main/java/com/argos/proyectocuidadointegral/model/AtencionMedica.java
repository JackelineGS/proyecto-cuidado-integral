package com.argos.proyectocuidadointegral.model;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "atencion_medica")
public class AtencionMedica {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_atencion")
    private Integer id;

    @Column(name = "diagnostico", length = 255)
    private String diagnostico;

    @Column(name = "tratamiento", columnDefinition = "TEXT")
    private String tratamiento;

    @Column(name = "observaciones", columnDefinition = "TEXT")
    private String observaciones;

    // Conexión hacia arriba: Muchas atenciones pertenecen a una Historia Clínica
    @ManyToOne
    @JoinColumn(name = "id_historia", nullable = false)
    private HistoriaClinica historiaClinica;

    // Conexión hacia abajo 1: Una atención médica puede registrar muchos Triajes
    @OneToMany(mappedBy = "atencionMedica", cascade = CascadeType.ALL)
    private List<Triaje> triajes = new ArrayList<>();

    // Conexión hacia abajo 2: Una atención médica puede registrar muchas Vacunaciones
    @OneToMany(mappedBy = "atencionMedica", cascade = CascadeType.ALL)
    private List<Vacunacion> vacunaciones = new ArrayList<>();

    public AtencionMedica() {}

    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }

    public String getDiagnostico() { return diagnostico; }
    public void setDiagnostico(String diagnostico) { this.diagnostico = diagnostico; }

    public String getTratamiento() { return tratamiento; }
    public void setTratamiento(String tratamiento) { this.tratamiento = tratamiento; }

    public String getObservaciones() { return observaciones; }
    public void setObservaciones(String observaciones) { this.observaciones = observaciones; }

    public HistoriaClinica getHistoriaClinica() {
        return historiaClinica;
    }
    public void setHistoriaClinica(HistoriaClinica historiaClinica) {
        this.historiaClinica = historiaClinica;
    }

    public List<Triaje> getTriaje() {
        return triajes;
    }
    public void setTriaje(List<Triaje> triajes) {
        this.triajes = triajes;
    }

    public List <Vacunacion> getVacunacion() {
        return vacunaciones;
    }
    public void setVacunacion(List<Vacunacion> vacunacion) {
        this.vacunaciones = vacunaciones;
    }

}

