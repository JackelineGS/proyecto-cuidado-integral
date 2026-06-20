package com.argos.proyectocuidadointegral.dto;

import java.time.LocalDateTime;
import java.util.List;

public class OrdenCompraDTO {

    private Long idOrden;
    private LocalDateTime fechaOrden;
    private Double total;
    private String estado;
    private String nombreCliente;
    private List<DetalleOrdenDTO> detalles;

    public OrdenCompraDTO() {}

    public Long getIdOrden() { return idOrden; }
    public void setIdOrden(Long idOrden) { this.idOrden = idOrden; }
    public LocalDateTime getFechaOrden() { return fechaOrden; }
    public void setFechaOrden(LocalDateTime fechaOrden) { this.fechaOrden = fechaOrden; }
    public Double getTotal() { return total; }
    public void setTotal(Double total) { this.total = total; }
    public String getEstado() { return estado; }
    public void setEstado(String estado) { this.estado = estado; }
    public String getNombreCliente() { return nombreCliente; }
    public void setNombreCliente(String nombreCliente) { this.nombreCliente = nombreCliente; }
    public List<DetalleOrdenDTO> getDetalles() { return detalles; }
    public void setDetalles(List<DetalleOrdenDTO> detalles) { this.detalles = detalles; }
}
