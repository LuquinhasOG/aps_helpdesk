package br.com.api.helpdesk.services;

import br.com.api.helpdesk.models.TicketModel;
import br.com.api.helpdesk.repositories.TicketRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TicketService {
    final TicketRepository ticketRepository;

    public TicketService(TicketRepository ticketRepository) {
        this.ticketRepository = ticketRepository;
    }

    public List<TicketModel> findAll() {
        return ticketRepository.findAll();
    }

    public Optional<TicketModel> findById(int idTicket) {
        return ticketRepository.findById(idTicket);
    }
}
