package br.com.grupotsm.EmployeeControl.resources;

import br.com.grupotsm.EmployeeControl.dto.exchange.ExchangeDTO;
import br.com.grupotsm.EmployeeControl.dto.exchange.ExchangeNewDTO;
import br.com.grupotsm.EmployeeControl.services.ExchangeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;

@RestController
@RequestMapping(value = "/exchanges")
public class ExchangeResource {

    @Autowired
    private ExchangeService service;

    @GetMapping
    public ResponseEntity<Page<ExchangeDTO>> findAll(Pageable pageable) {
        return ResponseEntity.ok().body(service.findAllPaged(pageable));
    }
    @GetMapping(value = "/{id}")
    public ResponseEntity<ExchangeDTO> findById(@PathVariable Long id) {
        return ResponseEntity.ok().body(service.findByIdDTO(id));
    }
    @PostMapping
    public ResponseEntity<ExchangeDTO> create(@RequestBody @Valid ExchangeNewDTO dto) {
        ExchangeDTO newDTO = service.create(dto);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(newDTO.getId()).toUri();
        return ResponseEntity.created(uri).body(newDTO);
    }
    /*

    @PutMapping(value = "/{id}")
    public ResponseEntity<ExchangeDTO> update(@PathVariable Long id, @RequestBody ExchangeUpdateDTO dto) {
        return ResponseEntity.ok().body(service.update(id, dto));
    }*/
    }
