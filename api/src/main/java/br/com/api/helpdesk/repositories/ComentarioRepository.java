package br.com.api.helpdesk.repositories;

import br.com.api.helpdesk.models.ComentarioModel;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ComentarioRepository extends JpaRepository<ComentarioModel, Integer> {
    Optional<List<ComentarioModel>> findByIdTicketComentario(int idTicket);
}
