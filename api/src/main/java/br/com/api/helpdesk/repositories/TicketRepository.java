package br.com.api.helpdesk.repositories;

import br.com.api.helpdesk.models.TicketModel;
import br.com.api.helpdesk.models.UsuarioModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TicketRepository extends JpaRepository<TicketModel, Integer> {
    Optional<List<TicketModel>> findByUsuarioAbertura(UsuarioModel usuarioAbertura);
}
