package br.com.api.helpdesk.services;

import br.com.api.helpdesk.exception.IdPatrimonioBadRequest;
import br.com.api.helpdesk.exception.PatrimonioNotFound;
import br.com.api.helpdesk.infra.RestErrorMessage;
import br.com.api.helpdesk.infra.RestExceptionHandler;
import br.com.api.helpdesk.models.PatrimonioModel;
import br.com.api.helpdesk.repositories.PatrimonioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

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

