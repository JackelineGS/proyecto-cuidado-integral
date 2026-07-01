package com.argos.proyectocuidadointegral.model;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "veterinario")
public class Veterinario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_veterinario")
    private Integer idVeterinario;

    @Column(name = "nombre", nullable = false, length = 100)
    private String nombre;

    @Column(name = "apellido", nullable = false, length = 100)
    private String apellido;

    @Column(name = "correo", length = 150)
    private String correo;

    @Column(name = "celular", length = 20)
    private String celular;


    @OneToMany(mappedBy = "veterinario", cascade = CascadeType.ALL)
    private List<Cita> citas;

    @OneToMany(mappedBy = "veterinario", cascade = CascadeType.ALL)
    private List<Horario> horarios;

    public Veterinario() {
    }

    public Veterinario(Integer idVeterinario, String nombre, String apellido, String correo, String celular) {
        this.idVeterinario = idVeterinario;
        this.nombre = nombre;
        this.apellido = apellido;
        this.correo = correo;
        this.celular = celular;
    }

    public Integer getIdVeterinario() { return idVeterinario; }
    public void setIdVeterinario(Integer idVeterinario) { this.idVeterinario = idVeterinario; }
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    public String getApellido() { return apellido; }
    public void setApellido(String apellido) { this.apellido = apellido; }
    public String getCorreo() { return correo; }
    public void setCorreo(String correo) { this.correo = correo; }
    public String getCelular() { return celular; }
    public void setCelular(String celular) { this.celular = celular; }

}
