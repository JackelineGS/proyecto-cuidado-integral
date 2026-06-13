package com.argos.proyectocuidadointegral.model;

import jakarta.persistence.*;

@Entity
@Table(name = "vacuna")
public class Vacuna {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_vacuna")
    private Integer id;

    @Column(name = "nombre", nullable = false, length = 150)
    private String nombre; // Ej: "Triple Felina", "Antirrábica"

    public Vacuna() {}

    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }
}
