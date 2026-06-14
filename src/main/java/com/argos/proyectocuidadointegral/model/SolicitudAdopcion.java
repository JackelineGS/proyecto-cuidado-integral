package com.argos.proyectocuidadointegral.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "solicitud_adopcion")
public class SolicitudAdopcion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_solicitud")
    private Integer id;

    @Column(name = "nombre_solicitante", nullable = false, length = 150)
    private String applicantName;

    @Column(name = "email", length = 150)
    private String email;

    @Column(name = "telefono", length = 20)
    private String phone;

    @Column(name = "distrito", length = 100)
    private String district;

    @ManyToOne
    @JoinColumn(name = "id_rescatada", nullable = false)
    private MascotaRescatada mascotaRescatada;

    @Column(name = "estado_solicitud", length = 30)
    private String requestStatus; // pendiente, en_evaluacion, confirmado, rechazado, finalizado

    @Column(name = "leido")
    private boolean read;

    @Column(name = "fecha_creacion")
    private LocalDateTime createdAt;

    public SolicitudAdopcion() {}

    // Getters y Setters
    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }

    public String getApplicantName() { return applicantName; }
    public void setApplicantName(String applicantName) { this.applicantName = applicantName; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getPhone() { return phone; }
    public void setPhone(String phone) { this.phone = phone; }

    public String getDistrict() { return district; }
    public void setDistrict(String district) { this.district = district; }

    public MascotaRescatada getMascotaRescatada() { return mascotaRescatada; }
    public void setMascotaRescatada(MascotaRescatada mascotaRescatada) { this.mascotaRescatada = mascotaRescatada; }

    public String getRequestStatus() { return requestStatus; }
    public void setRequestStatus(String requestStatus) { this.requestStatus = requestStatus; }

    public boolean isRead() { return read; }
    public void setRead(boolean read) { this.read = read; }

    public LocalDateTime getCreatedAt() { return createdAt; }
    public void setCreatedAt(LocalDateTime createdAt) { this.createdAt = createdAt; }

    public String getPetName() {
        return mascotaRescatada != null ? mascotaRescatada.getNombre() : null;
    }
}