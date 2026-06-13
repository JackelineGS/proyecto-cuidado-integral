package com.argos.proyectocuidadointegral.model;

import jakarta.persistence.*;
@Entity
@Table(name = "vacunacion")
public class Vacunacion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_vacunacion")
    private Integer id;

    // Muchas vacunaciones pertenecen a una Atención Médica específica
    @ManyToOne
    @JoinColumn(name = "id_atencion", nullable = false) // Coincide con la columna de tu imagen
    private AtencionMedica atencionMedica;

    // Muchas aplicaciones de vacuna corresponden a un tipo de Vacuna del catálogo
    @ManyToOne
    @JoinColumn(name = "id_vacuna") // Coincide con la columna 'id_vacuna' de tu imagen
    private Vacuna vacuna;

    // Constructor vacío obligatorio
    public Vacunacion() {}

    // Getters y Setters
    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }

    public AtencionMedica getAtencionMedica() { return atencionMedica; }
    public void setAtencionMedica(AtencionMedica atencionMedica) { this.atencionMedica = atencionMedica; }

    public Vacuna getVacuna() { return vacuna; }
    public void setVacuna(Vacuna vacuna) { this.vacuna = vacuna; }

}
