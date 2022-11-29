package br.com.grupotsm.EmployeeControl.services;

import br.com.grupotsm.EmployeeControl.dto.employee.EmployeeDTO;
import br.com.grupotsm.EmployeeControl.dto.employee.EmployeeNewDTO;
import br.com.grupotsm.EmployeeControl.dto.employee.EmployeeUpdateDTO;
import br.com.grupotsm.EmployeeControl.entities.Employee;
import br.com.grupotsm.EmployeeControl.repositories.EmployeeRepository;
import br.com.grupotsm.EmployeeControl.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;


@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository repository;
    @Autowired
    private StoreService storeService;
    @Autowired
    private LicenseService licenseService;

    @Transactional(readOnly = true)
    public Page<EmployeeDTO> findAllPaged(Pageable pageable, boolean justHired, boolean justAvailable){
        Page<Employee> obj = repository.findAll(pageable);
        Page<EmployeeDTO> dto = obj.map(EmployeeDTO::new);
        List<EmployeeDTO> employees = listActives(dto.stream().toList(), justHired, justAvailable);
        dto = new PageImpl<>(employees);
        return dto;
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
        Employee obj = findById(id);
        copyDtoToEntity(dto, obj);
        obj.setUpdated(LocalDateTime.now());

        obj = repository.save(obj);

        return new EmployeeDTO(obj);
    }

    private void copyDtoToEntity(EmployeeNewDTO dto, Employee obj) {
        obj.setBirthDate(dto.getBirthDate());
        obj.setCpf(dto.getCpf());
        obj.setName(dto.getName());
        obj.setEmail(dto.getEmail());
        obj.setDtAdmission(dto.getDtAdmission());
        obj.setStore(storeService.findById(dto.getIdStore()));
    }


    private void copyDtoToEntity(EmployeeUpdateDTO dto, Employee obj) {
        obj.setBirthDate(dto.getBirthDate() == null? obj.getBirthDate():dto.getBirthDate());
        obj.setName(dto.getName() == null? obj.getName(): dto.getName());
        obj.setEmail(dto.getEmail() == null? obj.getEmail():dto.getEmail());
        obj.setDtAdmission(dto.getDtAdmission() == null? obj.getDtAdmission():dto.getDtAdmission());
        obj.setDtResignation(dto.getDtResignation() == null ? obj.getDtResignation() : dto.getDtResignation());
        obj.setStore(storeService.findById(dto.getIdStore()));
    }
    @Transactional(readOnly = true)
    public boolean isActive(EmployeeDTO dto) {
        Employee obj = findById(dto.getId());
        Set licensesActive = licenseService.findActiveLicenseByEmployee(obj.getLicenses());

        return licensesActive.isEmpty();
    }
    @Transactional(readOnly = true)
    public List<EmployeeDTO> listActives(List<EmployeeDTO> dto, boolean isHired, boolean isAvailable) {
        if(isHired)
            dto = dto.stream().filter(e -> e.getDtResignation()==null ||
                    (e.getDtResignation().isAfter(LocalDate.now()) ||
                            e.getDtResignation().isEqual(LocalDate.now()))).collect(Collectors.toList());
        if(isAvailable)
            dto = dto.stream().filter(this::isActive).collect(Collectors.toList());
        return dto;
    }
}
