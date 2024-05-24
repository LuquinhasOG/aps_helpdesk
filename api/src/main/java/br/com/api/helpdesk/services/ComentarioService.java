package br.com.api.helpdesk.services;

import br.com.api.helpdesk.models.ComentarioModel;
import br.com.api.helpdesk.models.UsuarioModel;
import br.com.api.helpdesk.repositories.ComentarioRepository;
import br.com.api.helpdesk.repositories.UsuarioRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ComentarioService {
    @Autowired
    private ComentarioRepository comentarioRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Transactional
    public ComentarioModel save(ComentarioModel comentarioModel) {
        return comentarioRepository.save(comentarioModel);
    }

    public List<ComentarioModel> findAll() {
        return  comentarioRepository.findAll();
    }

    public Optional<ComentarioModel> findById(int idComentario) {
        return comentarioRepository.findById(idComentario);
    }

    public void atribuirUsuarioPorId(ComentarioModel comentario, int idUsuario) {
        UsuarioModel usuario = usuarioRepository.findById(idUsuario).get();
        comentario.setUsuarioComentario(usuario);
    }
}
