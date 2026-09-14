package cl.goldenoddjobs.solicitudes.controller;

import cl.goldenoddjobs.solicitudes.model.EstadoSolicitud;
import cl.goldenoddjobs.solicitudes.model.Postulacion;
import cl.goldenoddjobs.solicitudes.model.Solicitud;
import cl.goldenoddjobs.solicitudes.repository.PostulacionRepository;
import cl.goldenoddjobs.solicitudes.repository.SolicitudRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.web.bind.annotation.*;

import java.time.Instant;
import java.util.List;

@RestController
@RequestMapping("/api")
public class SolicitudController {

    private final SolicitudRepository solicitudRepository;
    private final PostulacionRepository postulacionRepository;

    public SolicitudController(SolicitudRepository solicitudRepository,
                                PostulacionRepository postulacionRepository) {
        this.solicitudRepository = solicitudRepository;
        this.postulacionRepository = postulacionRepository;
    }

    @PostMapping("/solicitudes")
    public ResponseEntity<Solicitud> crear(@RequestBody Solicitud solicitud,
                                            @AuthenticationPrincipal Jwt jwt) {
        solicitud.setSolicitanteSub(jwt.getSubject());
        solicitud.setEstado(EstadoSolicitud.PUBLICADA);
        solicitud.setCreadaEn(Instant.now());
        return ResponseEntity.ok(solicitudRepository.save(solicitud));
    }

    @GetMapping("/solicitudes/disponibles")
    public ResponseEntity<List<Solicitud>> disponibles() {
        return ResponseEntity.ok(solicitudRepository.findByEstado(EstadoSolicitud.PUBLICADA));
    }

    @PostMapping("/solicitudes/{id}/postulaciones")
    public ResponseEntity<Postulacion> postular(@PathVariable Long id,
                                                 @RequestBody Postulacion postulacion,
                                                 @AuthenticationPrincipal Jwt jwt) {
        postulacion.setSolicitudId(id);
        postulacion.setDesarrolladorSub(jwt.getSubject());
        postulacion.setCreadaEn(Instant.now());
        return ResponseEntity.ok(postulacionRepository.save(postulacion));
    }

    @GetMapping("/admin/solicitudes")
    public ResponseEntity<List<Solicitud>> todas() {
        return ResponseEntity.ok(solicitudRepository.findAll());
    }
}
