package cl.goldenoddjobs.requests.repository;

import cl.goldenoddjobs.requests.model.Proposal;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProposalRepository extends JpaRepository<Proposal, Long> {
}
