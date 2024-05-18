package br.com.api.helpdesk.controllers;

import br.com.api.helpdesk.dtos.TicketDto;
import br.com.api.helpdesk.models.EstadoTicketModel;
import br.com.api.helpdesk.models.TicketModel;
import br.com.api.helpdesk.services.TicketService;
import br.com.api.helpdesk.services.UsuarioService;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600) // libera para qualquer aplicação rodando no computador possa acessar a API
@RequestMapping("/tickets") // diz a URL onde ocorre a requisição Rest
public class TicketController {

    final TicketService ticketService;

    public TicketController(TicketService ticketService, UsuarioService usuarioService) {
        this.ticketService = ticketService;
        //this.usuarioService = usuarioService;
    }

    // método que retorna todos os chamandos do banco de bados
    @GetMapping
    public ResponseEntity<List<TicketModel>> getAllTickets() {
        return ResponseEntity.status(HttpStatus.OK).body(ticketService.findAll());
    }

    // pega um ticket em específico pelo id
    @GetMapping("{id_ticket}")
    public ResponseEntity<Object> getTicket(@PathVariable(name = "id_ticket") int idTicket) {
        Optional<TicketModel> ticket = ticketService.findById(idTicket);

        if (ticket.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Não encontrado: não existe nenhum chamado com este id");
        }

        return ResponseEntity.status(HttpStatus.OK).body(ticket.get());
    }

    @GetMapping("/usuario/{id_usuario}")
    public ResponseEntity<Object> getAllTicketsByUsuario(@PathVariable(name = "id_usuario") int idUsuario) {
        Optional<List<TicketModel>> ticket = ticketService.findByUsuarioId(idUsuario);

        if (ticket.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Não encontrado: não existe nenhum chamado com este id");
        }

        return ResponseEntity.status(HttpStatus.OK).body(ticket.get());
    }

    @PostMapping
    public ResponseEntity<Object> saveTicket(@RequestBody @Valid TicketDto ticketDto) {
        TicketModel ticketModel = new TicketModel();
        ticketService.atribuirUsuarioPorId(ticketModel, ticketDto.getUsuarioAbertura());
        ticketService.atribuirEstadoTicketPorId(ticketModel, ticketDto.getEstadoTicket());
        ticketModel.setTitulo(ticketDto.getTitulo());
        ticketModel.setDescricao(ticketDto.getDescricao());
        ticketModel.setDataAbertura(ticketDto.getDataAbertura());

        return ResponseEntity.status(HttpStatus.CREATED).body(ticketService.save(ticketModel));
    }

    @PutMapping("{id_ticket}")
    public ResponseEntity<Object> updateTicket(@PathVariable("id_ticket") int idTicket, @RequestBody @Valid TicketDto ticketDto) {
        Optional<TicketModel> ticket = ticketService.findById(idTicket);
        if (ticket.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Este chamado não existe");
        }
        TicketModel novoTicket = ticket.get();
        novoTicket.setTitulo(ticketDto.getTitulo());
        novoTicket.setDescricao(ticketDto.getDescricao());
        novoTicket.setDataFechamento(ticketDto.getDataFechamento());
        ticketService.atribuirEstadoTicketPorId(novoTicket, ticketDto.getEstadoTicket());

        return ResponseEntity.status(HttpStatus.OK).body(ticketService.save(novoTicket));
    }
}
