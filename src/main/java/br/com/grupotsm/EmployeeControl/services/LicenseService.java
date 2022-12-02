package br.com.grupotsm.EmployeeControl.services;

import br.com.grupotsm.EmployeeControl.dto.license.LicenseDTO;
import br.com.grupotsm.EmployeeControl.dto.license.LicenseSaveDTO;
import br.com.grupotsm.EmployeeControl.entities.License;
import br.com.grupotsm.EmployeeControl.entities.enums.ReasonType;
import br.com.grupotsm.EmployeeControl.repositories.EmployeeRepository;
import br.com.grupotsm.EmployeeControl.repositories.LicenseRepository;
import br.com.grupotsm.EmployeeControl.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;


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

    @Transactional
    public LicenseDTO save(LicenseSaveDTO dto) {
        License obj = new License();

        copyDtoToEntity(dto, obj);
        obj.setCreated(LocalDateTime.now());
        obj = repository.save(obj);

        return new LicenseDTO(obj);
    }

    /*@Transactional
    public LicenseDTO update(Long id,LicenseSaveDTO dto) {
        License obj = new License();

        copyDtoToEntity(dto, obj);
        obj.setUpdated(LocalDateTime.now());
        obj = repository.save(obj);

        return new LicenseDTO(obj);
    }*/

    @Transactional(readOnly = true)
    public Optional<License> findActiveLicenseByEmployee(long employeeId) {
        return repository.findActiveLicenseByEmployee(employeeId, LocalDate.now());
    }
    @Transactional(readOnly = true)
    public Set<License> findActiveLicenseByEmployee(Set<License> licenses) {
        LocalDate today = LocalDate.now();
        licenses = licenses.stream()
                .filter((l -> (l.getDtStart().isBefore(today) || l.getDtStart().isEqual(today))
                        && (today.isBefore(l.getDtEnd()==null? l.getDtExpected() : l.getDtEnd()) || today.isEqual(l.getDtEnd()==null? l.getDtExpected() : l.getDtEnd()))))
                .collect(Collectors.toSet());
        return licenses;
    }

    /* TODO criar copyDtoToEntity para create
        tratamento de data end para update.
    */
    private void copyDtoToEntity(LicenseSaveDTO dto, License obj) {
        obj.setDescription(dto.getDescription() == null? obj.getDescription() : dto.getDescription());
        obj.setEmployee(dto.getEmployeeId() == null ? obj.getEmployee() : employeeService.findById(dto.getEmployeeId()));
        obj.setDtExpected(dto.getDtExpected() == null ? obj.getDtExpected() : dto.getDtExpected());
        obj.setDtStart(dto.getDtStart() == null ? obj.getDtStart() : dto.getDtStart());
        obj.setReason(dto.getReason() == 0 ? obj.getReason() : ReasonType.toEnum(dto.getReason()));
    }
}
