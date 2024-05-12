package br.com.api.helpdesk.repositories;

import br.com.api.helpdesk.models.UsuarioModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UsuarioRepository extends JpaRepository<UsuarioModel, Integer> {
    public boolean existsByEmail(String email);

    Optional<UsuarioModel> findOneByIdUsuario(int idUsuario);

    Optional<UsuarioModel> findByEmail(String email);
}
