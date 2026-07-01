package com.argos.proyectocuidadointegral.dto;

import java.time.LocalDate;
import java.time.LocalTime;

import jakarta.persistence.criteria.CriteriaBuilder;
import lombok.Getter;
import lombok.Setter;

public class CitaDTO {
    private Integer id;
    private Integer clienteDni;
    private String clienteNombre;
    private String pacienteNombre;
    private String doctor;
    private LocalDate fecha;
    private LocalTime hora;
    private String status;
    private String motivoConsulta;
    private boolean tieneHistorialMedico;


    public CitaDTO() {}

    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }
    public Integer getClienteDni() { return clienteDni; }
    public void setClienteDni(Integer correoCliente) { this.clienteDni = clienteDni; }
    public String getClienteNombre() { return clienteNombre; }
    public void setClienteNombre(String clienteNombree) { this.clienteNombre = clienteNombre; }
    public String getPacienteNombre() { return pacienteNombre; }
    public void setPacienteNombre(String pacienteNombre) { this.pacienteNombre = pacienteNombre; }
    public String getDoctor() { return doctor; }
    public void setDoctor(String doctor) { this.doctor = doctor; }
    public LocalDate getFecha() { return fecha; }
    public void setFecha(LocalDate fecha) { this.fecha = fecha; }
    public LocalTime getHora() { return hora; }
    public void setHora(LocalTime hora) { this.hora = hora; }
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
    public String getMotivoConsulta() { return motivoConsulta; }
    public void setMotivoConsulta(String motivoConsulta) { this.motivoConsulta = motivoConsulta; }
    public boolean isTieneHistorialMedico() {
        return tieneHistorialMedico;
    }
    public void setTieneHistorialMedico(boolean tieneHistorialMedico){this.tieneHistorialMedico = tieneHistorialMedico;}

}









































