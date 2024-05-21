package br.com.api.helpdesk.controllers;

import br.com.api.helpdesk.dtos.PatrimonioDto;
import br.com.api.helpdesk.models.PatrimonioModel;
import br.com.api.helpdesk.repositories.PatrimonioRepository;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
public class PatrimonioController {
    @Autowired
    PatrimonioRepository patrimonioRepository;

    @PostMapping("/patrimonio")
    public ResponseEntity<PatrimonioModel> salvarPatrimonio(@RequestBody @Valid PatrimonioDto patrimonioDto) {
        var patrimonioModel = new PatrimonioModel();
        BeanUtils.copyProperties(patrimonioDto, patrimonioModel);
        return ResponseEntity.status(HttpStatus.CREATED).body(patrimonioRepository.save(patrimonioModel));
    }

    @GetMapping("/patrimonio")
    public ResponseEntity<List<PatrimonioModel>> getAllPatrimonio() {
        return ResponseEntity.status(HttpStatus.OK).body(patrimonioRepository.findAll());
    }

    @GetMapping("/patrimonio/{id}")
    public ResponseEntity<Object> getOnePatrimonio(@PathVariable(value = "id") UUID id) {
        Optional<PatrimonioModel> patrimonio = patrimonioRepository.findById((id));
        return patrimonio.<ResponseEntity<Object>>map(patrimonioModel -> ResponseEntity.status(HttpStatus.OK).body(patrimonioModel)).orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).body("Patrimônio não foi encontrado."));
    }

    @PutMapping("/patrimonio/{id}")
    public ResponseEntity<Object> updatePatrimonio(@PathVariable(value="id") UUID id, @RequestBody @Valid PatrimonioDto patrimonioDto) {
        Optional<PatrimonioModel> patrimonio = patrimonioRepository.findById(id);
        if(patrimonio.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Patrimônio não foi encontrado.");
        }
        var patrimonioModel = patrimonio.get();
        BeanUtils.copyProperties(patrimonioDto, patrimonioModel);
        return ResponseEntity.status(HttpStatus.OK).body(patrimonioRepository.save(patrimonioModel));
    }

    @DeleteMapping("/patrimonio/{id}")
    public ResponseEntity<Object> deletePatrimonio(@PathVariable(value="id") UUID id) {
        Optional<PatrimonioModel> patrimonio = patrimonioRepository.findById(id);
        if(patrimonio.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Patrimônio não foi encontrado.");
        }
        patrimonioRepository.delete(patrimonio.get());
        return ResponseEntity.status(HttpStatus.OK).body("Patrimônio deletado.");
    }
}

