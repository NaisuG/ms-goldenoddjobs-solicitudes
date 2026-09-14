package cl.goldenoddjobs.solicitudes.repository;

import cl.goldenoddjobs.solicitudes.model.EstadoSolicitud;
import cl.goldenoddjobs.solicitudes.model.Solicitud;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SolicitudRepository extends JpaRepository<Solicitud, Long> {
    List<Solicitud> findByEstado(EstadoSolicitud estado);
}
