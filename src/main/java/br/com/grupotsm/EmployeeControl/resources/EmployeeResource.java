package br.com.grupotsm.EmployeeControl.resources;

import br.com.grupotsm.EmployeeControl.dto.employee.EmployeeDTO;
import br.com.grupotsm.EmployeeControl.dto.employee.EmployeeNewDTO;
import br.com.grupotsm.EmployeeControl.dto.employee.EmployeeUpdateDTO;
import br.com.grupotsm.EmployeeControl.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;

@RestController
@RequestMapping(value = "/employees")
public class EmployeeResource {

    @Autowired
    private EmployeeService service;

    @GetMapping
    public ResponseEntity<Page<EmployeeDTO>> findAll(Pageable pageable,
                                                     @RequestParam(name = "justHired", defaultValue = "true") boolean justHired,
                                                     @RequestParam(name = "justAvailable", defaultValue = "false") boolean justAvailable) {
        return ResponseEntity.ok().body(service.findAllPaged(pageable,justHired, justAvailable));
    }
    @GetMapping(value = "/{id}")
    public ResponseEntity<EmployeeDTO> findById(@PathVariable Long id) {
        return ResponseEntity.ok().body(service.findByIdDTO(id));
    }
    @PostMapping
    public ResponseEntity<EmployeeDTO> admission(@RequestBody @Valid EmployeeNewDTO dto) {
        EmployeeDTO newDTO = service.admission(dto);

        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(newDTO.getId()).toUri();
        return ResponseEntity.created(uri).body(newDTO);
    }
    @PutMapping(value = "/{id}")
    public ResponseEntity<EmployeeDTO> update(@PathVariable Long id, @RequestBody @Valid EmployeeUpdateDTO dto) {
        EmployeeDTO updatedDTO = service.update(id, dto);
        return ResponseEntity.ok().body(updatedDTO);
    }
}
