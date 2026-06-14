package com.argos.proyectocuidadointegral.model;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "mascota_rescatada")
public class MascotaRescatada {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_rescatada")
    private Integer id;

    @Column(name = "nombre", nullable = false, length = 100)
    private String nombre;

    @Column(name = "especie", length = 50)
    private String especie; // PERRO, GATO, etc.

    @Column(name = "raza", length = 50)
    private String raza;

    @Column(name = "sexo", length = 20)
    private String sexo;

    @Column(name = "edad")
    private Integer edad;

    @Column(name = "estado", length = 30)
    private String estado; // DISPONIBLE, EN_PROCESO, ADOPTADO

    @Column(name = "descripcion", columnDefinition = "TEXT")
    private String descripcion;

    @Column(name = "fecha_ingreso")
    private LocalDate fechaIngreso;

    public MascotaRescatada() {}

    // Getters y Setters
    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getEspecie() { return especie; }
    public void setEspecie(String especie) { this.especie = especie; }

    public String getRaza() { return raza; }
    public void setRaza(String raza) { this.raza = raza; }

    public String getSexo() { return sexo; }
    public void setSexo(String sexo) { this.sexo = sexo; }

    public Integer getEdad() { return edad; }
    public void setEdad(Integer edad) { this.edad = edad; }

    public String getEstado() { return estado; }
    public void setEstado(String estado) { this.estado = estado; }

    public String getDescripcion() { return descripcion; }
    public void setDescripcion(String descripcion) { this.descripcion = descripcion; }

    public LocalDate getFechaIngreso() { return fechaIngreso; }
    public void setFechaIngreso(LocalDate fechaIngreso) { this.fechaIngreso = fechaIngreso; }
}
