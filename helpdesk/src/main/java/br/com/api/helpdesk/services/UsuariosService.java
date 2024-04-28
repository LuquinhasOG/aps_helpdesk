package br.com.api.helpdesk.services;

import br.com.api.helpdesk.models.UsuariosModel;
import br.com.api.helpdesk.repositories.UsuariosRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

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
}
