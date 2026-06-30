package com.argos.proyectocuidadointegral.dto;
import lombok.Data;
import java.time.LocalDateTime;
import java.util.List;

@Data
public class OrdenCompraDTO {

    private Integer idOrden;
    private LocalDateTime fechaOrden;
    private Double total;
    private String estado;
    private String nombreCliente;
    private List<DetalleOrdenDTO> detalles;

    public OrdenCompraDTO() {}

}
