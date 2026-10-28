package cl.goldenoddjobs.requests.controller;

import cl.goldenoddjobs.requests.model.AppRequest;
import cl.goldenoddjobs.requests.model.AppRequestStatus;
import cl.goldenoddjobs.requests.model.Proposal;
import cl.goldenoddjobs.requests.repository.AppRequestRepository;
import cl.goldenoddjobs.requests.repository.ProposalRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.web.bind.annotation.*;

import java.time.Instant;
import java.util.List;

@RestController
@RequestMapping("/api")
public class AppRequestController {

    private final AppRequestRepository appRequestRepository;
    private final ProposalRepository proposalRepository;

    public AppRequestController(AppRequestRepository appRequestRepository,
                                ProposalRepository proposalRepository) {
        this.appRequestRepository = appRequestRepository;
        this.proposalRepository = proposalRepository;
    }

    @PostMapping("/solicitudes")
    @PreAuthorize("hasRole('SOLICITANTE')")
    public ResponseEntity<AppRequest> createRequest(@RequestBody AppRequest appRequest,
                                                    @AuthenticationPrincipal Jwt jwt) {
        appRequest.setRequesterSub(jwt.getSubject());
        appRequest.setStatus(AppRequestStatus.PUBLISHED);
        appRequest.setCreatedAt(Instant.now());
        return ResponseEntity.ok(appRequestRepository.save(appRequest));
    }

    @GetMapping("/solicitudes/disponibles")
    @PreAuthorize("hasRole('DESARROLLADOR')")
    public ResponseEntity<List<AppRequest>> listAvailable() {
        return ResponseEntity.ok(appRequestRepository.findByStatus(AppRequestStatus.PUBLISHED));
    }

    @PostMapping("/solicitudes/{id}/postulaciones")
    @PreAuthorize("hasRole('DESARROLLADOR')")
    public ResponseEntity<Proposal> submitProposal(@PathVariable Long id,
                                                   @RequestBody Proposal proposal,
                                                   @AuthenticationPrincipal Jwt jwt) {
        proposal.setRequestId(id);
        proposal.setDeveloperSub(jwt.getSubject());
        proposal.setCreatedAt(Instant.now());
        return ResponseEntity.ok(proposalRepository.save(proposal));
    }

    @GetMapping("/admin/solicitudes")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<List<AppRequest>> listAll() {
        return ResponseEntity.ok(appRequestRepository.findAll());
    }
}
