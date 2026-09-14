package cl.goldenoddjobs.solicitudes.repository;

import cl.goldenoddjobs.solicitudes.model.Postulacion;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostulacionRepository extends JpaRepository<Postulacion, Long> {
}
