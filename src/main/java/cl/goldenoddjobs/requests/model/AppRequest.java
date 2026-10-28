package cl.goldenoddjobs.requests.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import java.time.Instant;

@Entity
@Table(name = "solicitud")
public class AppRequest {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JsonProperty("titulo")
    @Column(name = "titulo")
    private String title;

    @JsonProperty("descripcion")
    @Column(name = "descripcion", length = 2000)
    private String description;

    @JsonProperty("tipoApp")
    @Column(name = "tipo_app")
    private String appType; // MOVIL, WEB, ESCRITORIO

    @JsonProperty("solicitanteSub")
    @Column(name = "solicitante_sub")
    private String requesterSub;

    @JsonProperty("estado")
    @Convert(converter = AppRequestStatusConverter.class)
    @Column(name = "estado")
    private AppRequestStatus status;

    @JsonProperty("creadaEn")
    @Column(name = "creada_en")
    private Instant createdAt;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }
    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }
    public String getAppType() { return appType; }
    public void setAppType(String appType) { this.appType = appType; }
    public String getRequesterSub() { return requesterSub; }
    public void setRequesterSub(String requesterSub) { this.requesterSub = requesterSub; }
    public AppRequestStatus getStatus() { return status; }
    public void setStatus(AppRequestStatus status) { this.status = status; }
    public Instant getCreatedAt() { return createdAt; }
    public void setCreatedAt(Instant createdAt) { this.createdAt = createdAt; }
}
