package br.com.api.helpdesk.repositories;

import br.com.api.helpdesk.models.UsuariosModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface UsuariosRepository extends JpaRepository<UsuariosModel, Integer> {
    public boolean existsByEmail(String email);

    Optional<UsuariosModel> findOneByIdUsuario(int idUsuario);
}
