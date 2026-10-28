package cl.goldenoddjobs.requests.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.Instant;

@Entity
@Table(name = "postulacion")
public class Proposal {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JsonProperty("solicitudId")
    @Column(name = "solicitud_id")
    private Long requestId;

    @JsonProperty("desarrolladorSub")
    @Column(name = "desarrollador_sub")
    private String developerSub;

    @JsonProperty("precioPropuesto")
    @Column(name = "precio_propuesto")
    private BigDecimal proposedPrice;

    @JsonProperty("creadaEn")
    @Column(name = "creada_en")
    private Instant createdAt;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public Long getRequestId() { return requestId; }
    public void setRequestId(Long requestId) { this.requestId = requestId; }
    public String getDeveloperSub() { return developerSub; }
    public void setDeveloperSub(String developerSub) { this.developerSub = developerSub; }
    public BigDecimal getProposedPrice() { return proposedPrice; }
    public void setProposedPrice(BigDecimal proposedPrice) { this.proposedPrice = proposedPrice; }
    public Instant getCreatedAt() { return createdAt; }
    public void setCreatedAt(Instant createdAt) { this.createdAt = createdAt; }
}
