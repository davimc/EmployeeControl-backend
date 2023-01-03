package br.com.grupotsm.EmployeeControl.resources;

import br.com.grupotsm.EmployeeControl.DTO.exchange.ExchangeDTO;
import br.com.grupotsm.EmployeeControl.entities.enums.StoreType;
import br.com.grupotsm.EmployeeControl.services.ExchangeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/exchanges")
public class ExchangeResource {

    @Autowired
    private ExchangeService service;

    @GetMapping
    public ResponseEntity<Page<ExchangeDTO>> findAll(Pageable pageable,
                                                    @RequestParam(value="dtMin", defaultValue = "")String min,
                                                    @RequestParam(value="dtMax", defaultValue = "")String max,
                                                    @RequestParam(value = "state", defaultValue = "0") Integer state,
                                                    @RequestParam(value = "employee", defaultValue = "") String name) {
        return ResponseEntity.ok().body(service.findAllActives(pageable, min, max, state, name));
    }
    @GetMapping("/{id}")
    public ResponseEntity<ExchangeDTO> findById(@PathVariable Long id) {
        return ResponseEntity.ok().body(service.findById(id));
    }
}
