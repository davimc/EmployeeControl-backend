package br.com.grupotsm.EmployeeControl.services;

import br.com.grupotsm.EmployeeControl.dto.license.LicenseDTO;
import br.com.grupotsm.EmployeeControl.dto.license.LicenseSaveDTO;
import br.com.grupotsm.EmployeeControl.entities.License;
import br.com.grupotsm.EmployeeControl.repositories.LicenseRepository;
import br.com.grupotsm.EmployeeControl.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.Optional;


@Service
public class LicenseService {

    @Autowired
    private LicenseRepository repository;

    @Autowired
    private EmployeeService employeeService;

    @Transactional(readOnly = true)
    public Page<LicenseDTO> findAllPaged(Pageable pageable){
        Page<License> obj = repository.findAll(pageable);
        return obj.map(LicenseDTO::new);
    }

    @Transactional(readOnly = true)
    public LicenseDTO findById(Long id) {
        Optional<License> obj = repository.findById(id);
        return new LicenseDTO(obj.orElseThrow(() -> new ObjectNotFoundException(id, License.class)));
    }

    @Transactional(readOnly = false)
    public LicenseDTO admission(LicenseSaveDTO dto) {
        License obj = new License();
        copyDtoToEntity(dto, obj);
        obj.setCreated(LocalDateTime.now());

        obj = repository.save(obj);

        return new LicenseDTO(obj);
    }
    @Transactional(readOnly = false)
    public LicenseDTO update(Long id,LicenseSaveDTO dto) {
        License obj = new License();
        copyDtoToEntity(dto, obj);
        obj.setUpdated(LocalDateTime.now());

        obj = repository.save(obj);

        return new LicenseDTO(obj);
    }

    private void copyDtoToEntity(LicenseSaveDTO dto, License obj) {
        obj.setDescription(dto.getDescription());
        obj.setEmployee(employeeService.findById(dto.getEmployeeId()));
        obj.setDtEnd(dto.getDtEnd());
        obj.setDtStart(dto.getDtStart());
        obj.setReason(obj.getReason());
    }
}
