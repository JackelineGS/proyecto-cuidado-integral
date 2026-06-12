package com.argos.proyectocuidadointegral.dto;

import java.time.LocalDate;
import java.time.LocalTime;

public class CitaRegistroDTO {

    private String nombreCliente;
    private String correoCliente;
    private String celularCliente;
    private Integer dniCliente;
    private String nombreMascota;
    private String especieMascota; // E.g., PERRO, GATO
    private Long idVeterinario;
    private LocalDate fecha;
    private LocalTime hora;
    private String motivoConsulta;
    // Default constructor
    public CitaRegistroDTO() {}
    // Getters and Setters
    public String getNombreCliente() { return nombreCliente; }
    public void setNombreCliente(String nombreCliente) { this.nombreCliente = nombreCliente; }
    public String getCorreoCliente() { return correoCliente; }
    public void setCorreoCliente(String correoCliente) { this.correoCliente = correoCliente; }
    public String getCelularCliente() { return celularCliente; }
    public void setCelularCliente(String celularCliente) { this.celularCliente = celularCliente; }
    public Integer getDniCliente() { return dniCliente; }
    public void setDniCliente(Integer dniCliente) { this.dniCliente = dniCliente; }
    public String getNombreMascota() { return nombreMascota; }
    public void setNombreMascota(String nombreMascota) { this.nombreMascota = nombreMascota; }
    public String getEspecieMascota() { return especieMascota; }
    public void setEspecieMascota(String especieMascota) { this.especieMascota = especieMascota; }
    public Long getIdVeterinario() { return idVeterinario; }
    public void setIdVeterinario(Long idVeterinario) { this.idVeterinario = idVeterinario; }
    public LocalDate getFecha() { return fecha; }
    public void setFecha(LocalDate fecha) { this.fecha = fecha; }
    public LocalTime getHora() { return hora; }
    public void setHora(LocalTime hora) { this.hora = hora; }
    public String getMotivoConsulta() { return motivoConsulta; }
    public void setMotivoConsulta(String motivoConsulta) { this.motivoConsulta = motivoConsulta; }

}
