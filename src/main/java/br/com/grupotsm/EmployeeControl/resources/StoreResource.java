package br.com.grupotsm.EmployeeControl.resources;

import br.com.grupotsm.EmployeeControl.DTO.store.StoreDTO;
import br.com.grupotsm.EmployeeControl.DTO.store.StoreExpandedDTO;
import br.com.grupotsm.EmployeeControl.services.StoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/stores")
public class StoreResource {

    @Autowired
    private StoreService service;

    @GetMapping
    public ResponseEntity<List<StoreDTO>> findAll() {
        return ResponseEntity.ok().body(service.findAll());
    }
    @GetMapping(value = "/{id}")
    public ResponseEntity<StoreExpandedDTO> findExpanded(@PathVariable Long id) {
        return ResponseEntity.ok().body(service.findExpanded(id));
    }
}
