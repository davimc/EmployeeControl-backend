package br.com.grupotsm.EmployeeControl.resources;

import br.com.grupotsm.EmployeeControl.DTO.exchange.ExchangeDTO;
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
                                                    @RequestParam(value = "justActives", defaultValue = "false") boolean justActives) {
        return ResponseEntity.ok().body(service.findAllActives(pageable, min, max, justActives));
    }
    @GetMapping("/{id}")
    public ResponseEntity<ExchangeDTO> findById(@PathVariable Long id) {
        return ResponseEntity.ok().body(service.findById(id));
    }
}
