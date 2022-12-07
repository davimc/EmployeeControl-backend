package br.com.grupotsm.EmployeeControl.services;

import br.com.grupotsm.EmployeeControl.DTO.license.LicenseDTO;
import br.com.grupotsm.EmployeeControl.entities.License;
import br.com.grupotsm.EmployeeControl.repositories.LicenseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;



@Service
public class LicenseService {
    @Autowired
    private LicenseRepository repository;

    @Transactional(readOnly = true)
    public Page<LicenseDTO> findAll(Pageable pageable) {
        Page<License> obj = repository.findAll(pageable);

        return obj.map(LicenseDTO::new);
    }
}
