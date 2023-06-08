package br.com.grupotsm.EmployeeControl.services;

import br.com.grupotsm.EmployeeControl.DTO.license.LicenseDTO;
import br.com.grupotsm.EmployeeControl.DTO.license.LicenseNewDTO;
import br.com.grupotsm.EmployeeControl.DTO.license.LicenseUpdateDTO;
import br.com.grupotsm.EmployeeControl.entities.Employee;
import br.com.grupotsm.EmployeeControl.entities.License;
import br.com.grupotsm.EmployeeControl.repositories.LicenseRepository;
import br.com.grupotsm.EmployeeControl.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;


@Service
public class LicenseService {
    @Autowired
    private LicenseRepository repository;
    @Autowired
    private EmployeeService employeeService;

    @Transactional(readOnly = true)
    protected License findById(Long id) {
        return repository.findById(id).orElseThrow(() -> new ObjectNotFoundException(id, License.class));
    }

    @Transactional(readOnly = true)
    public Page<LicenseDTO> findAllActives(Pageable pageable, String min, String max, boolean justActives) {
        LocalDate dtMin = min.equals("") ? LocalDate.now().minusYears(1)
                : LocalDate.parse(min);
        LocalDate dtMax = max.equals("") ? LocalDate.now()
                : LocalDate.parse(max);
        Page<LicenseDTO> dto = repository.findAllActives(pageable, dtMin, dtMax, justActives);

        return dto;
    }
    @Transactional(readOnly = true)
    public LicenseDTO findDTOById(Long id) {
        License obj = findById(id);
        return new LicenseDTO(obj);
    }

    //TODO controlar para que não haja uma licença em cima de outra
    public LicenseDTO insert(LicenseNewDTO newDTO) {
        Employee employee = employeeService.findById(newDTO.getEmployeeId());
        License obj = newDTO.toModel(employee);

        obj = repository.save(obj);
        return new LicenseDTO(obj);
    }

    //TODO controlar para que não haja uma licença em cima de outra

    /**TODO fazer tratamento para que um licença não seja alterada com dias incompatíveis
     * (férias poder ser alterada por falta e nisso a pessoa ficar com 30 dias de falta no sistema)
     * provavelmente o jeito mais lógico seria retirar a opção de poder alterar a razão da licença
     */
    public LicenseDTO update(Long id, LicenseUpdateDTO dto) {
        License obj = findById(id);
        dto.toModel(obj);
        obj = repository.save(obj);

        return new LicenseDTO(obj);
    }
}
