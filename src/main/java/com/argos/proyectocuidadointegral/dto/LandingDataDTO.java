package com.argos.proyectocuidadointegral.dto;


import java.util.List;

public class LandingDataDTO {

    private List<MascotaRescatadaDTO> mascotasDisponibles;
    private List<ProductoDTO> productosDestacados;
    private List<VeterinarioDTO> veterinarios;
    public LandingDataDTO() {}
    public LandingDataDTO(List<MascotaRescatadaDTO> mascotasDisponibles, List<ProductoDTO> productosDestacados, List<VeterinarioDTO> veterinarios) {
        this.mascotasDisponibles = mascotasDisponibles;
        this.productosDestacados = productosDestacados;
        this.veterinarios = veterinarios;
    }
    // Getters and Setters
    public List<MascotaRescatadaDTO> getMascotasDisponibles() { return mascotasDisponibles; }
    public void setMascotasDisponibles(List<MascotaRescatadaDTO> mascotasDisponibles) { this.mascotasDisponibles = mascotasDisponibles; }
    public List<ProductoDTO> getProductosDestacados() { return productosDestacados; }
    public void setProductosDestacados(List<ProductoDTO> productosDestacados) { this.productosDestacados = productosDestacados; }
    public List<VeterinarioDTO> getVeterinarios() { return veterinarios; }
    public void setVeterinarios(List<VeterinarioDTO> veterinarios) { this.veterinarios = veterinarios; }
}
