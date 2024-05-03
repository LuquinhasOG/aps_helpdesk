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
import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600) // libera para qualquer aplicação rodando no computador possa acessar a API
@RequestMapping("/usuarios") // diz a URL onde ocorre a requisição Rest
public class UsuariosControler {
    final UsuariosService usuariosService;

    public UsuariosControler(UsuariosService usuariosService) {
        this.usuariosService = usuariosService;
    }

    // método post de usuários, sua função é de criar um conta
    @PostMapping
    public ResponseEntity<Object> saveUsuarios(@RequestBody @Valid UsuariosDto usuarioDto) {
        // antes de tudo, irá verificar se o email já está cadastrado
        // se já estiver, irá enviar a estado de conflito para a requisição
        if (usuariosService.existsByEmail(usuarioDto.getEmail())) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Conflito: já existe um usuário com este email registrado");
        }

        UsuariosModel usuarioModel = new UsuariosModel(); // cria um modelo para trabalhar com os dados
        BeanUtils.copyProperties(usuarioDto, usuarioModel); // copia os dados para o model

        // utiliza um método set do modelo para que seja colocada a data de agora na coluna data_criacao_usuario no banco de dados
        usuarioModel.setDataCriacaoUsuario(Date.valueOf(LocalDate.now(ZoneId.of("UTC"))));

        return ResponseEntity.status(HttpStatus.CREATED).body(this.usuariosService.save(usuarioModel));
    }

    // retorna todos os usuário do banco de dados
    @GetMapping
    public ResponseEntity<List<UsuariosModel>> getAllUsuarios() {
        return ResponseEntity.status(HttpStatus.OK).body(usuariosService.findAll());
    }

    // retorn um usuário pelo id dele
    @GetMapping("/{id_usuario}")
    public ResponseEntity<Object> getOneUsuarios(@PathVariable(value = "id_usuario") int idUsuario) {
        // tenta encontrar o usuário com o idqueremos
        Optional<UsuariosModel> usuariosModelOptional = usuariosService.findById(idUsuario);

        // caso não conseguiu encontrar retorna o estado "não encontrado"
        if (!usuariosModelOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Não encontrado: não existe um usuário com este id");
        }

        return ResponseEntity.status(HttpStatus.OK).body(usuariosModelOptional.get());
    }

    @DeleteMapping("/{id_usuario}")
    public ResponseEntity<Object> deleteUsuarios(@PathVariable(value = "id_usuario") int idUsuario) {
        // tenta encontrar o usuário com o id que queremos
        Optional<UsuariosModel> usuariosModelOptional = usuariosService.findById(idUsuario);

        // caso não conseguiu encontrar retorna o estado "não encontrado"
        if (!usuariosModelOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Não encontrado: não existe um usuário com este id");
        }

        usuariosService.delete(usuariosModelOptional.get());
        return ResponseEntity.status(HttpStatus.OK).body("Usuário deletado com sucesso");
    }

    @PutMapping("/{id_usuario}")
    public ResponseEntity<Object> updateUsuarios(@PathVariable(value = "id_usuario") int idUsuario, @RequestBody @Valid UsuariosDto usuariosDto) {
        // tenta encontrar o usuário com o id que queremos
        Optional<UsuariosModel> usuariosModelOptional = usuariosService.findById(idUsuario);

        // caso não conseguiu encontrar retorna o estado "não encontrado"
        if (!usuariosModelOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Não encontrado: não existe um usuário com este id");
        }

        // pega os dados do usuário encontrado
        UsuariosModel usuariosModel = usuariosModelOptional.get();

        // atualiza os dados
        usuariosModel.setNome(usuariosDto.getNome());
        usuariosModel.setSenha(usuariosDto.getSenha());
        usuariosModel.setEmail(usuariosDto.getEmail());
        usuariosModel.setDataNascimento(usuariosDto.getDataNascimento());

        // salva as alterações no banco de dados
        return ResponseEntity.status(HttpStatus.OK).body(usuariosService.save(usuariosModel));
    }
}
