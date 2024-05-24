package br.com.api.helpdesk.repositories;

import br.com.api.helpdesk.models.ComentarioModel;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ComentarioRepository extends JpaRepository<ComentarioModel, Integer> {

}
