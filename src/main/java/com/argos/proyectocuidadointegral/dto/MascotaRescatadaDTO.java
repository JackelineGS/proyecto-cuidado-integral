package com.argos.proyectocuidadointegral.dto;

public class MascotaRescatadaDTO {

    private Long idRescatada;
    private String nombre;
    private String especie;
    private String raza;
    private String sexo;
    private Integer edad;
    private String estado;
    public MascotaRescatadaDTO() {}
    public MascotaRescatadaDTO(Long idRescatada, String nombre, String especie, String raza, String sexo, Integer edad, String estado) {
        this.idRescatada = idRescatada;
        this.nombre = nombre;
        this.especie = especie;
        this.raza = raza;
        this.sexo = sexo;
        this.edad = edad;
        this.estado = estado;
    }
    // Getters and Setters
    public Long getIdRescatada() { return idRescatada; }
    public void setIdRescatada(Long idRescatada) { this.idRescatada = idRescatada; }
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
}
