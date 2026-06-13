package com.argos.proyectocuidadointegral.model;

import jakarta.persistence.*;
@Entity
@Table(name = "triaje")
public class Triaje {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_triaje")
    private Integer id;

    @Column(name = "peso", precision = 53)
    private Double peso;

    @Column(name = "temperatura", precision = 53)
    private Double temperatura;

    @Column(name = "sintomas", length = 255)
    private String sintomas;

    @ManyToOne //Muchos triajes pertenecen a una atencion medica
    @JoinColumn(name = "id_atencion", nullable = false)
    private AtencionMedica atencionMedica;


    public Triaje() {}

    // Getters y Setters
    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }

    public Double getPeso() { return peso; }
    public void setPeso(Double peso) { this.peso = peso; }

    public Double getTemperatura() { return temperatura; }
    public void setTemperatura(Double temperatura) { this.temperatura = temperatura; }

    public String getSintomas() { return sintomas; }
    public void setSintomas(String sintomas) { this.sintomas = sintomas; }

    public AtencionMedica getAtencionMedica() { return atencionMedica; }
    public void setAtencionMedica(HistoriaClinica historiaClinica) { this.atencionMedica = atencionMedica; }

}
