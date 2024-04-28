package br.com.api.helpdesk.services;

import br.com.api.helpdesk.models.UsuariosModel;
import br.com.api.helpdesk.repositories.UsuariosRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class UsuariosService {
    final UsuariosRepository usuariosRepository;

    public UsuariosService(UsuariosRepository usuariosRepository) {
        this.usuariosRepository = usuariosRepository;
    }

    @Transactional // transactional garante a aplicação dará rollback caso a transação de errado
    public UsuariosModel save(UsuariosModel usuarioModel) {
        return usuariosRepository.save(usuarioModel);
    }

    // método que retorna se email já exite no banco de dados
    public boolean existsByEmail(String email) {
        return usuariosRepository.existsByEmail(email);
    }

    // método que retorna todos usuários
    public List<UsuariosModel> findAll() {
        return usuariosRepository.findAll();
    }

    // retorna apenas um usuário específico
    public Optional<UsuariosModel> findById(int idUsuario) {
        return usuariosRepository.findOneByIdUsuario(idUsuario);
    }
}
