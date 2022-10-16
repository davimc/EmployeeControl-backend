package br.com.grupotsm.EmployeeControl.services;

import br.com.grupotsm.EmployeeControl.dto.EmployeeDTO;
import br.com.grupotsm.EmployeeControl.dto.EmployeeNewDTO;
import br.com.grupotsm.EmployeeControl.entities.Employee;
import br.com.grupotsm.EmployeeControl.repositories.EmployeeRepository;
import br.com.grupotsm.EmployeeControl.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository repository;
    @Autowired
    private StoreService storeService;

    public Page<EmployeeDTO> findAllPaged(Pageable pageable){
        Page<Employee> obj = repository.findAll(pageable);
        return obj.map(EmployeeDTO::new);
    }

    public EmployeeDTO find(Long id) {
        Optional<Employee> obj = repository.findById(id);
        return new EmployeeDTO(obj.orElseThrow(() -> new ObjectNotFoundException(id, Employee.class)));
    }

    public EmployeeDTO admission(EmployeeNewDTO dto) {
        Employee obj = new Employee();
        fromDTO(dto, obj);

        obj = repository.save(obj);

        return new EmployeeDTO(obj);
    }


    private Employee fromDTO(EmployeeNewDTO dto, Employee obj) {
        obj.setCpf(dto.getCpf());
        obj.setBirthDate(dto.getBirthDate());
        obj.setName(dto.getName());
        obj.setEmail(dto.getEmail());
        obj.setDtAdmission(dto.getDtAdmission());
        obj.setStore(storeService.findById(dto.getIdStore()));

        return obj;
    }
}
