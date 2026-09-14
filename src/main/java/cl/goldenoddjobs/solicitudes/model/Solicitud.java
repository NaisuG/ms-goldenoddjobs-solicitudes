package cl.goldenoddjobs.solicitudes.model;

import jakarta.persistence.*;
import java.time.Instant;

@Entity
@Table(name = "solicitud")
public class Solicitud {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String titulo;

    @Column(length = 2000)
    private String descripcion;

    @Column(name = "tipo_app")
    private String tipoApp; // MOVIL, WEB, ESCRITORIO

    @Column(name = "solicitante_sub")
    private String solicitanteSub;

    @Enumerated(EnumType.STRING)
    private EstadoSolicitud estado;

    @Column(name = "creada_en")
    private Instant creadaEn;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getTitulo() { return titulo; }
    public void setTitulo(String titulo) { this.titulo = titulo; }
    public String getDescripcion() { return descripcion; }
    public void setDescripcion(String descripcion) { this.descripcion = descripcion; }
    public String getTipoApp() { return tipoApp; }
    public void setTipoApp(String tipoApp) { this.tipoApp = tipoApp; }
    public String getSolicitanteSub() { return solicitanteSub; }
    public void setSolicitanteSub(String solicitanteSub) { this.solicitanteSub = solicitanteSub; }
    public EstadoSolicitud getEstado() { return estado; }
    public void setEstado(EstadoSolicitud estado) { this.estado = estado; }
    public Instant getCreadaEn() { return creadaEn; }
    public void setCreadaEn(Instant creadaEn) { this.creadaEn = creadaEn; }
}
