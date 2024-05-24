package br.com.api.helpdesk.services;

import br.com.api.helpdesk.models.EstadoTicketModel;
import br.com.api.helpdesk.models.PatrimonioModel;
import br.com.api.helpdesk.models.TicketModel;
import br.com.api.helpdesk.models.UsuarioModel;
import br.com.api.helpdesk.repositories.PatrimonioRepository;
import br.com.api.helpdesk.repositories.TicketRepository;
import br.com.api.helpdesk.repositories.UsuarioRepository;
import br.com.api.helpdesk.repositories.EstadoTicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class TicketService {
    @Autowired
    private TicketRepository ticketRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private EstadoTicketRepository estadoTicketRepository;

    @Autowired
    private PatrimonioRepository patrimonioRepository;

    public TicketModel save(TicketModel ticketModel) {
        return ticketRepository.save(ticketModel);
    }

    public List<TicketModel> findAll() {
        return ticketRepository.findAll();
    }

    public Optional<TicketModel> findById(int idTicket) {
        return ticketRepository.findById(idTicket);
    }

    public Optional<EstadoTicketModel> findEstadoTicketById(int idEstadoTicket) {
        return estadoTicketRepository.findById(idEstadoTicket);
    }

    public Optional<List<TicketModel>> findByUsuarioId(int idUsuario) {
        Optional<UsuarioModel> usuario = usuarioRepository.findById(idUsuario);
        return ticketRepository.findByUsuarioAbertura(usuario.get());
    }

    public void atribuirUsuarioPorId(TicketModel ticketModel, int idUsuario) {
        UsuarioModel usuarioModel = usuarioRepository.findOneByIdUsuario(idUsuario).get();
        ticketModel.setUsuarioAbertura(usuarioModel);
    }

    public void atribuirEstadoTicketPorId(TicketModel ticketModel, int idEstadoTicket) {
        EstadoTicketModel estadoTicketModel = estadoTicketRepository.findOneByIdEstadoTicket(idEstadoTicket).get();
        ticketModel.setEstadoTicket(estadoTicketModel);
    }

    public void atribuirPatrimonioPorId(TicketModel ticketModel, UUID idPatrimonio) {
        PatrimonioModel patrimonioModel = patrimonioRepository.findById(idPatrimonio).get();
        ticketModel.setPatrimonioTicket(patrimonioModel);
    }
}
