package br.com.api.helpdesk.repositories;

import br.com.api.helpdesk.models.TicketModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TicketRepository extends JpaRepository<TicketModel, Integer> {
}
