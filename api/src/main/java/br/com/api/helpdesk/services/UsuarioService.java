package br.com.api.helpdesk.services;

import br.com.api.helpdesk.models.UsuarioModel;
import br.com.api.helpdesk.repositories.UsuarioRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {
    final UsuarioRepository usuariosRepository;

    public UsuarioService(UsuarioRepository usuariosRepository) {
        this.usuariosRepository = usuariosRepository;
    }

    @Transactional // transactional garante a aplicação dará rollback caso a transação de errado
    public UsuarioModel save(UsuarioModel usuarioModel) {
        return usuariosRepository.save(usuarioModel);
    }

    // método que retorna se email já exite no banco de dados
    public boolean existsByEmail(String email) {
        return usuariosRepository.existsByEmail(email);
    }

    // método que retorna todos usuários
    public List<UsuarioModel> findAll() {
        return usuariosRepository.findAll();
    }

    // retorna apenas um usuário específico
    public Optional<UsuarioModel> findById(int idUsuario) {
        return usuariosRepository.findById(idUsuario);
    }

    // retorn apenas um usuário pelo email
    public Optional<UsuarioModel> findByEmail(String email) {
        return usuariosRepository.findByEmail(email);
    }

    @Transactional
    public void delete(UsuarioModel usuariosModel) {
        usuariosRepository.delete(usuariosModel);
    }
}
