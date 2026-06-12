package com.argos.proyectocuidadointegral.dto;

public class VeterinarioDTO {
    private Long idVeterinario;
    private String nombreCompleto;
    private String correo;
    private String celular;
    public VeterinarioDTO() {}
    public VeterinarioDTO(Long idVeterinario, String nombreCompleto, String correo, String celular) {
        this.idVeterinario = idVeterinario;
        this.nombreCompleto = nombreCompleto;
        this.correo = correo;
        this.celular = celular;
    }
    // Getters and Setters
    public Long getIdVeterinario() { return idVeterinario; }
    public void setIdVeterinario(Long idVeterinario) { this.idVeterinario = idVeterinario; }
    public String getNombreCompleto() { return nombreCompleto; }
    public void setNombreCompleto(String nombreCompleto) { this.nombreCompleto = nombreCompleto; }
    public String getCorreo() { return correo; }
    public void setCorreo(String correo) { this.correo = correo; }
    public String getCelular() { return celular; }
    public void setCelular(String celular) { this.celular = celular; }
}
