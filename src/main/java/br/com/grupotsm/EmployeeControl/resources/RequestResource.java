package br.com.grupotsm.EmployeeControl.resources;

import br.com.grupotsm.EmployeeControl.DTO.request.RequestDTO;
import br.com.grupotsm.EmployeeControl.services.RequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/requests")
public class RequestResource {

    @Autowired
    private RequestService service;

    @GetMapping
    public ResponseEntity<List<RequestDTO>> findAll() {
        return ResponseEntity.ok().body(service.findAll());
    }
    @GetMapping("/{id}")
    public ResponseEntity<RequestDTO> findById(@PathVariable Long id) {
        return ResponseEntity.ok().body(service.findById(id));
    }
    @GetMapping("/exchange/{idExchange}")
    public ResponseEntity<List<RequestDTO>> findExchange(@PathVariable Long idExchange) {
        return ResponseEntity.ok().body(service.findByExchange(idExchange));
    }

}
