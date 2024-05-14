package br.com.api.helpdesk.services;

import br.com.api.helpdesk.models.EstadoTicketModel;
import br.com.api.helpdesk.models.TicketModel;
import br.com.api.helpdesk.models.UsuarioModel;
import br.com.api.helpdesk.repositories.TicketRepository;
import br.com.api.helpdesk.repositories.UsuarioRepository;
import br.com.api.helpdesk.repositories.EstadoTicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TicketService {
    @Autowired
    private TicketRepository ticketRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private EstadoTicketRepository estadoTicketRepository;

    public TicketModel save(TicketModel ticketModel) {
        return ticketRepository.save(ticketModel);
    }

    public List<TicketModel> findAll() {
        return ticketRepository.findAll();
    }

    public Optional<TicketModel> findById(int idTicket) {
        return ticketRepository.findById(idTicket);
    }

    public void atribuirUsuarioPorId(TicketModel ticketModel, int idUsuario) {
        UsuarioModel usuarioModel = usuarioRepository.findOneByIdUsuario(idUsuario).get();
        ticketModel.setUsuarioAbertura(usuarioModel);
    }

    public void atribuirEstadoTicketPorId(TicketModel ticketModel, int idEstadoTicket) {
        EstadoTicketModel estadoTicketModel = estadoTicketRepository.findOneByIdEstadoTicket(idEstadoTicket).get();
        ticketModel.setEstadoTicket(estadoTicketModel);
    }
}
