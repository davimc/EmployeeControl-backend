package br.com.grupotsm.EmployeeControl.services;

import br.com.grupotsm.EmployeeControl.dto.employee.EmployeeDTO;
import br.com.grupotsm.EmployeeControl.dto.employee.EmployeeNewDTO;
import br.com.grupotsm.EmployeeControl.dto.employee.EmployeeUpdateDTO;
import br.com.grupotsm.EmployeeControl.entities.Employee;
import br.com.grupotsm.EmployeeControl.entities.License;
import br.com.grupotsm.EmployeeControl.repositories.EmployeeRepository;
import br.com.grupotsm.EmployeeControl.repositories.StoreRepository;
import br.com.grupotsm.EmployeeControl.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;


@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository repository;
    @Autowired
    private StoreRepository storeRepository;
    @Autowired
    private LicenseService licenseService;

    @Transactional(readOnly = true)
    public Page<EmployeeDTO> findAllPaged(Pageable pageable){
        Page<Employee> obj = repository.findAll(pageable);
        return obj.map(EmployeeDTO::new);
    }

    @Transactional(readOnly = true)
    protected Employee findById(Long id) {
        Optional<Employee> obj = repository.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException(id, Employee.class));
    }
    @Transactional(readOnly = true)
    public EmployeeDTO findByIdDTO(Long id) {
        return new EmployeeDTO(findById(id));
    }

    @Transactional(readOnly = false)
    public EmployeeDTO admission(EmployeeNewDTO dto) {
        Employee obj = new Employee();
        copyDtoToEntity(dto, obj);
        obj.setCreated(LocalDateTime.now());

        obj = repository.save(obj);

        return new EmployeeDTO(obj);
    }
    @Transactional(readOnly = false)
    public EmployeeDTO update(Long id,EmployeeUpdateDTO dto) {
        Employee obj = new Employee();
        copyDtoToEntity(dto, obj);
        obj.setUpdated(LocalDateTime.now());

        obj = repository.save(obj);

        return new EmployeeDTO(obj);
    }

    private void copyDtoToEntity(EmployeeUpdateDTO dto, Employee obj) {
        obj.setBirthDate(dto.getBirthDate());
        obj.setName(dto.getName());
        obj.setEmail(dto.getEmail());
        obj.setDtAdmission(dto.getDtAdmission());
        obj.setDtResignation(dto.getDtResignation());
        obj.setStore(storeRepository.findById(dto.getIdStore()).get());
    }


    private void copyDtoToEntity(EmployeeNewDTO dto, Employee obj) {
        obj.setCpf(dto.getCpf());
        obj.setBirthDate(dto.getBirthDate());
        obj.setName(dto.getName());
        obj.setEmail(dto.getEmail());
        obj.setDtAdmission(dto.getDtAdmission());
        obj.setStore(storeRepository.findById(dto.getIdStore()).get());
    }

    @Transactional(readOnly = true)
    public boolean isActive(EmployeeDTO dto) {
        Employee obj = findById(dto.getId());
        Optional<License> licenseActive = licenseService.findActiveLicenseByEmployee(obj.getId());

        return licenseActive.isEmpty() || obj.getDtResignation()!=null;
    }
    @Transactional(readOnly = true)
    public List<EmployeeDTO> listActives(List<EmployeeDTO> dto) {
        dto.stream().forEach(e -> {
            if((!isActive(e)))
               dto.remove(e);
        });
        return dto;
    }
}
