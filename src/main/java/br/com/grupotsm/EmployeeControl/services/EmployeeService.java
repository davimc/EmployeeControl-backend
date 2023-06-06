package br.com.grupotsm.EmployeeControl.services;

import br.com.grupotsm.EmployeeControl.DTO.employee.EmployeeDTO;
import br.com.grupotsm.EmployeeControl.DTO.employee.EmployeeShortDTO;
import br.com.grupotsm.EmployeeControl.entities.Employee;
import br.com.grupotsm.EmployeeControl.repositories.EmployeeRepository;
import br.com.grupotsm.EmployeeControl.services.exceptions.DatabaseException;
import br.com.grupotsm.EmployeeControl.services.exceptions.ObjectNotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;


@Service
public class EmployeeService implements UserDetailsService {

    private static Logger logger = LoggerFactory.getLogger(EmployeeService.class);
    @Autowired
    private EmployeeRepository repository;

    @Transactional(readOnly = true)
    private Employee findById(Long id) {
        return repository.findById(id).orElseThrow(() -> new ObjectNotFoundException(id, EmployeeService.class));

    }

    @Transactional(readOnly = true)
    public Page<EmployeeShortDTO> findAll(Pageable pageable, boolean isAvailable) {
        Page<Employee> obj = repository.findAllActives(pageable);

        return obj.map(EmployeeShortDTO::new);
    }
    @Transactional(readOnly = true)
    public EmployeeDTO findDTOById(Long id) {
        Employee obj = findById(id);
        return new EmployeeDTO(obj);
    }


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<Employee> usr = repository.findByCpf(username);
        if(usr.isPresent()) {
            logger.info("User found: " + username);
            return usr.get();
        }
        logger.error("CPF not found: " + username);
        throw new UsernameNotFoundException("CPF not found: " + username);
    }


    public void delete(Long id) {
        try{
            repository.delete(findById(id));
        }catch (DataIntegrityViolationException e) {
            throw new DatabaseException("There is a dependency");
        }
    }
}
