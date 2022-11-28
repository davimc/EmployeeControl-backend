package br.com.grupotsm.EmployeeControl.resources;

import br.com.grupotsm.EmployeeControl.dto.store.StoreDTO;
import br.com.grupotsm.EmployeeControl.dto.store.StoreSaveDTO;
import br.com.grupotsm.EmployeeControl.services.StoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/stores")
public class StoreResource {

    @Autowired
    private StoreService service;

    @GetMapping
    public ResponseEntity<Page<StoreDTO>> findAll(Pageable pageable) {
        return ResponseEntity.ok().body(service.findAllPaged(pageable));
    }
    @GetMapping(value = "/{id}")
    public ResponseEntity<StoreDTO> findById(@PathVariable Long id,
                                             @RequestParam(name = "isHired", defaultValue="true") boolean isHired,
                                             @RequestParam(name = "isAvailable", defaultValue = "false") boolean isAvailable) {
        return ResponseEntity.ok().body(service.findByIdDTO(id, isHired,isAvailable));
    }
}
