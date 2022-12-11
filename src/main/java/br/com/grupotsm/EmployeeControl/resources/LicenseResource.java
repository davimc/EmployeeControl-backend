package br.com.grupotsm.EmployeeControl.resources;

import br.com.grupotsm.EmployeeControl.DTO.license.LicenseDTO;
import br.com.grupotsm.EmployeeControl.services.LicenseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/licenses")
public class LicenseResource {

    @Autowired
    private LicenseService service;

    @GetMapping
    public ResponseEntity<Page<LicenseDTO>> findAll(Pageable pageable, @RequestParam(value = "justActives", defaultValue = "false") boolean justActives) {
        return ResponseEntity.ok().body(service.findAllActives(pageable, justActives));
    }
    @GetMapping("/{id}")
    public ResponseEntity<LicenseDTO> findById(@PathVariable Long id) {
        return ResponseEntity.ok().body(service.findById(id));
    }
}
