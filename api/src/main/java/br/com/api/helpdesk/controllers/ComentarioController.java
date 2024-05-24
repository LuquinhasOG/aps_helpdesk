package br.com.api.helpdesk.controllers;

import br.com.api.helpdesk.dtos.ComentarioDto;
import br.com.api.helpdesk.models.ComentarioModel;
import br.com.api.helpdesk.services.ComentarioService;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/comentarios")
public class ComentarioController {
    @Autowired
    private ComentarioService comentarioService;

    @PostMapping
    public ResponseEntity<ComentarioModel> salvarComentario(@RequestBody @Valid ComentarioDto comentario) {
        ComentarioModel comentarioModel = new ComentarioModel();
        comentarioModel.setConteudoComentario(comentario.getConteudoComentario());
        comentarioModel.setIdTicketComentario(comentario.getIdTicketComentario());
        comentarioModel.setDataPublicacao(comentario.getDataPublicacao());
        comentarioService.atribuirUsuarioPorId(comentarioModel, comentario.getIdUsuarioComentario());

        return ResponseEntity.status(HttpStatus.CREATED).body(comentarioModel);
    }

    @GetMapping
    public ResponseEntity<Object> findAll() {
        return ResponseEntity.status(HttpStatus.OK).body(comentarioService.findAll());
    }

    @GetMapping("/{id_comentario}")
    public ResponseEntity<Object> findByIdComentario(@PathVariable(value = "id_comentario") int idComentario) {
        Optional<ComentarioModel> comentario = comentarioService.findById(idComentario);
        if (comentario.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"message\": \"não encontrado\"}");
        }

        return ResponseEntity.status(HttpStatus.OK).body(comentario.get());
    }
}
