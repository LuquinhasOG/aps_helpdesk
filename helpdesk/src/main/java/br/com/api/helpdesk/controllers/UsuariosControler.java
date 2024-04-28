package br.com.api.helpdesk.controllers;

import br.com.api.helpdesk.dtos.UsuariosDto;
import br.com.api.helpdesk.models.UsuariosModel;
import br.com.api.helpdesk.services.UsuariosService;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.time.LocalDate;
import java.time.ZoneId;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/usuarios")
public class UsuariosControler {
    final UsuariosService usuariosService;

    public UsuariosControler(UsuariosService usuariosService) {
        this.usuariosService = usuariosService;
    }

    // método post de usuários, sua função é de criar um conta
    @PostMapping
    public ResponseEntity<Object> saveUsuarios(@RequestBody @Valid UsuariosDto usuarioDto) {
        UsuariosModel usuarioModel = new UsuariosModel(); // cria um modelo para trabalhar com os dados
        BeanUtils.copyProperties(usuarioDto, usuarioModel); // copia os dados para o model

        // utiliza um método set do modelo para que seja colocada a data de agora na coluna data_criacao_usuario no banco de dados
        usuarioModel.setDataCriacaoUsuario(Date.valueOf(LocalDate.now(ZoneId.of("UTC"))));

        return ResponseEntity.status(HttpStatus.CREATED).body(this.usuariosService.save(usuarioModel));
    }
}
