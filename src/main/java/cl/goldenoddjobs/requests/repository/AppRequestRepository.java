package cl.goldenoddjobs.requests.repository;

import cl.goldenoddjobs.requests.model.AppRequest;
import cl.goldenoddjobs.requests.model.AppRequestStatus;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AppRequestRepository extends JpaRepository<AppRequest, Long> {
    List<AppRequest> findByStatus(AppRequestStatus status);
}
