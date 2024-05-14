package br.com.api.helpdesk.repositories;

import br.com.api.helpdesk.models.EstadoTicketModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface EstadoTicketRepository extends JpaRepository<EstadoTicketModel, Integer> {
    Optional<EstadoTicketModel> findOneByIdEstadoTicket(int idEstadoTicket);
}
