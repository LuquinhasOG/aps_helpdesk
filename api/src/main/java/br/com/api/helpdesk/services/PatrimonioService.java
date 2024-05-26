package br.com.api.helpdesk.services;

import br.com.api.helpdesk.exception.IdPatrimonioBadRequest;
import br.com.api.helpdesk.models.PatrimonioModel;
import br.com.api.helpdesk.repositories.PatrimonioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class PatrimonioService {
    @Autowired
    private PatrimonioRepository repository;

    @Autowired
    private IdPatrimonioBadRequest badRequest;

    public List<PatrimonioModel> findAll() {
        return repository.findAll();
    }

    public PatrimonioModel findById(UUID id) { // ARRUMAR DEPOIS
        Optional<PatrimonioModel> patrimonio = repository.findById(id);
        return patrimonio.orElseThrow(IdPatrimonioBadRequest::new) ;
    }

    public PatrimonioModel create(PatrimonioModel patrimonioModel) {
        return repository.save(patrimonioModel);
    }

    public PatrimonioModel update(PatrimonioModel patrimonioModel, UUID id) {
        patrimonioModel.setIdPatrimonio(id);
        return repository.save(patrimonioModel);
    }

    public void delete(UUID id) {
        repository.deleteById(id);
    }
}

