package br.com.grupotsm.EmployeeControl.resources;

import br.com.grupotsm.EmployeeControl.dto.license.LicenseDTO;
import br.com.grupotsm.EmployeeControl.dto.license.LicenseNewDTO;
import br.com.grupotsm.EmployeeControl.dto.license.LicenseUpdateDTO;
import br.com.grupotsm.EmployeeControl.services.LicenseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;

@RestController
@RequestMapping(value = "/licenses")
public class LicenseResource {

    @Autowired
    private LicenseService service;

    @GetMapping
    public ResponseEntity<Page<LicenseDTO>> findAll(Pageable pageable) {
        return ResponseEntity.ok().body(service.findAllPaged(pageable));
    }
    @GetMapping(value = "/{id}")
    public ResponseEntity<LicenseDTO> findById(@PathVariable Long id) {
        return ResponseEntity.ok().body(service.findByIdDTO(id));
    }
    @PostMapping
    public ResponseEntity<LicenseDTO> create(@RequestBody @Valid LicenseNewDTO dto) {
        LicenseDTO newDTO = service.save(dto);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(newDTO.getId()).toUri();
        return ResponseEntity.created(uri).body(newDTO);
    }
    @PutMapping(value = "/{id}")
    public ResponseEntity<LicenseDTO> update(@PathVariable Long id, @RequestBody LicenseUpdateDTO dto) {
        return ResponseEntity.ok().body(service.update(id, dto));
    }


}
