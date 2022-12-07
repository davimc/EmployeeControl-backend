package br.com.grupotsm.EmployeeControl.resources;

import br.com.grupotsm.EmployeeControl.DTO.license.LicenseDTO;
import br.com.grupotsm.EmployeeControl.services.LicenseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/licenses")
public class LicenseResource {

    @Autowired
    private LicenseService service;

    @GetMapping
    public ResponseEntity<Page<LicenseDTO>> findAll(Pageable pageable) {
        return ResponseEntity.ok().body(service.findAll(pageable));
    }
}
