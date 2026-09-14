package cl.goldenoddjobs.solicitudes.model;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.Instant;

@Entity
@Table(name = "postulacion")
public class Postulacion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "solicitud_id")
    private Long solicitudId;

    @Column(name = "desarrollador_sub")
    private String desarrolladorSub;

    @Column(name = "precio_propuesto")
    private BigDecimal precioPropuesto;

    @Column(name = "creada_en")
    private Instant creadaEn;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public Long getSolicitudId() { return solicitudId; }
    public void setSolicitudId(Long solicitudId) { this.solicitudId = solicitudId; }
    public String getDesarrolladorSub() { return desarrolladorSub; }
    public void setDesarrolladorSub(String desarrolladorSub) { this.desarrolladorSub = desarrolladorSub; }
    public BigDecimal getPrecioPropuesto() { return precioPropuesto; }
    public void setPrecioPropuesto(BigDecimal precioPropuesto) { this.precioPropuesto = precioPropuesto; }
    public Instant getCreadaEn() { return creadaEn; }
    public void setCreadaEn(Instant creadaEn) { this.creadaEn = creadaEn; }
}
