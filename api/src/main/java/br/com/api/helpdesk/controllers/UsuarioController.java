package br.com.api.helpdesk.controllers;

import br.com.api.helpdesk.dtos.LoginDto;
import br.com.api.helpdesk.dtos.UsuarioDto;
import br.com.api.helpdesk.models.UsuarioModel;
import br.com.api.helpdesk.services.UsuarioService;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600) // libera para qualquer aplicação rodando no computador possa acessar a API
@RequestMapping("/usuarios") // diz a URL onde ocorre a requisição Rest
public class UsuarioController {
    final UsuarioService usuarioService;

    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    // método post de usuários, sua função é de criar um conta
    @PostMapping
    public ResponseEntity<Object> saveUsuarios(@RequestBody @Valid UsuarioDto usuarioDto) {
        // antes de tudo, irá verificar se o email já está cadastrado
        // se já estiver, irá enviar a estado de conflito para a requisição
        if (usuarioService.existsByEmail(usuarioDto.getEmail())) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body("{ \"message\": \"Conflito: já existe um usuário com este email registrado\" }");
        }

        UsuarioModel usuarioModel = new UsuarioModel(); // cria um modelo para trabalhar com os dados
        BeanUtils.copyProperties(usuarioDto, usuarioModel); // copia os dados para o model

        // utiliza um método set do modelo para que seja colocada a data de agora na coluna data_criacao_usuario no banco de dados
        usuarioModel.setDataCriacaoUsuario(Date.valueOf(LocalDate.now(ZoneId.of("UTC"))));

        return ResponseEntity.status(HttpStatus.CREATED).body(this.usuarioService.save(usuarioModel));
    }

    // método que recebe informações de login e autentica e devolve
    @PostMapping("/login")
    public ResponseEntity<Object> getUsuarioLogin(@RequestBody LoginDto login) {
        if (!usuarioService.existsByEmail(login.getEmail())) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{ \"message\": \"Não existe nenhuma conta com este email\" }");
        }

        Optional<UsuarioModel> usuario = usuarioService.findByEmail(login.getEmail());
        if (!Objects.equals(login.getSenha(), usuario.get().getSenha())) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{ \"message\": \"Não existe nenhuma conta com este email\" }");
        }

        return ResponseEntity.status(HttpStatus.OK).body(usuario.get());
    }

    // retorna todos os usuário do banco de dados
    @GetMapping
    public ResponseEntity<List<UsuarioModel>> getAllUsuarios() {
        return ResponseEntity.status(HttpStatus.OK).body(usuarioService.findAll());
    }

    // retorn um usuário pelo id dele
    @GetMapping("/id/{id_usuario}")
    public ResponseEntity<Object> getOneUsuarioById(@PathVariable(value = "id_usuario") int idUsuario) {
        // tenta encontrar o usuário com o idqueremos
        Optional<UsuarioModel> usuariosModelOptional = usuarioService.findById(idUsuario);

        // caso não conseguiu encontrar retorna o estado "não encontrado"
        if (!usuariosModelOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Não encontrado: não existe um usuário com este id");
        }

        return ResponseEntity.status(HttpStatus.OK).body(usuariosModelOptional.get());
    }

    //@GetMapping("/email/{email_usuario}")
    //public ResponseEntity<Object> getOneUsuarioByEmail(@PathVariable(value = "email_usuario") String email) {
    //    Optional<UsuarioModel> usuariosModelOptional = usuarioService.findByEmail(email);

        // caso não conseguiu encontrar retorna o estado "não encontrado"
    //    if (!usuariosModelOptional.isPresent()) {
    //        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Não encontrado: não existe um usuário com este email");
    //    }

    //    return ResponseEntity.status(HttpStatus.OK).body(usuariosModelOptional.get());
    //}

    @DeleteMapping("/{id_usuario}")
    public ResponseEntity<Object> deleteUsuarios(@PathVariable(value = "id_usuario") int idUsuario) {
        // tenta encontrar o usuário com o id que queremos
        Optional<UsuarioModel> usuariosModelOptional = usuarioService.findById(idUsuario);

        // caso não conseguiu encontrar retorna o estado "não encontrado"
        if (!usuariosModelOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Não encontrado: não existe um usuário com este id");
        }

        usuarioService.delete(usuariosModelOptional.get());
        return ResponseEntity.status(HttpStatus.OK).body("Usuário deletado com sucesso");
    }

    @PutMapping("/{id_usuario}")
    public ResponseEntity<Object> updateUsuarios(@PathVariable(value = "id_usuario") int idUsuario, @RequestBody @Valid UsuarioDto usuariosDto) {
        // tenta encontrar o usuário com o id que queremos
        Optional<UsuarioModel> usuariosModelOptional = usuarioService.findById(idUsuario);

        // caso não conseguiu encontrar retorna o estado "não encontrado"
        if (!usuariosModelOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Não encontrado: não existe um usuário com este id");
        }

        // pega os dados do usuário encontrado
        UsuarioModel usuariosModel = usuariosModelOptional.get();

        // atualiza os dados
        usuariosModel.setNome(usuariosDto.getNome());
        usuariosModel.setSenha(usuariosDto.getSenha());
        usuariosModel.setEmail(usuariosDto.getEmail());
        usuariosModel.setDataNascimento(usuariosDto.getDataNascimento());

        // salva as alterações no banco de dados
        return ResponseEntity.status(HttpStatus.OK).body(usuarioService.save(usuariosModel));
    }
}