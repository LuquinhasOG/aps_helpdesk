package br.com.api.helpdesk.controllers;

import br.com.api.helpdesk.models.TicketModel;
import br.com.api.helpdesk.services.TicketService;
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

    public TicketController(TicketService ticketService) {
        this.ticketService = ticketService;
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

   // @PostMapping
}
