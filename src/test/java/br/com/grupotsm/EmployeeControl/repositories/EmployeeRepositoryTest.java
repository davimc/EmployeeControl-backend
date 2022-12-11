package br.com.grupotsm.EmployeeControl.repositories;

import br.com.grupotsm.EmployeeControl.DTO.employee.EmployeeDTO;
import br.com.grupotsm.EmployeeControl.entities.Employee;
import br.com.grupotsm.EmployeeControl.test.Factory;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.util.Optional;

@DataJpaTest
public class EmployeeRepositoryTest {

    @Autowired
    private EmployeeRepository repository;
    private long existingId;
    private long nonExistingId;
    private long dependentId;
    private String existingCpf;
    private String nonExistingCpf;
    private long countTotalIds;

    @BeforeEach
    public void setUp() {
        existingId = 1L;
        nonExistingId = 1000L;
        dependentId = 4L;
        existingCpf = "248.686-73";
        nonExistingCpf = "248.686-78";
        countTotalIds = repository.count();
    }

    @Test
    public void findByIdShouldReturnNonEmptyOptionalEmployeeWhenIdExists() {
        Assertions.assertDoesNotThrow(() -> {
            Optional<Employee> obj = repository.findById(existingId);
            Assertions.assertTrue(obj.isPresent());
            Assertions.assertEquals(obj.get().getId(), existingId);
            Assertions.assertEquals(obj.get().getName(), "Sandra de Fatima");
            Assertions.assertEquals(obj.get().getGender(), 'M');
            Assertions.assertEquals(obj.get().getEmail(), "sollicitudin@icloud.org");
        });
    }
    @Test
    public void findByIdShouldReturnEmptyOptionalEmployeeWhenIdDoesNotExist() {
        Assertions.assertDoesNotThrow(()-> {
            Optional<Employee> obj = repository.findById(nonExistingId);
            Assertions.assertFalse(obj.isPresent());
        });
    }
    @Test
    public void findByCpfShouldReturnNonEmptyOptionalEmployeeWhenCPFExists() {
        Assertions.assertDoesNotThrow(() -> {
            Optional<Employee> obj = repository.findByCpf(existingCpf);
            Assertions.assertTrue(obj.isPresent());
            Assertions.assertEquals(obj.get().getId(), existingId);
            Assertions.assertEquals(obj.get().getName(), "Sandra de Fatima");
            Assertions.assertEquals(obj.get().getGender(), 'M');
            Assertions.assertEquals(obj.get().getEmail(), "sollicitudin@icloud.org");
        });
    }

    @Test
    public void findByCpfShouldReturnEmptyOptionalEmployeeWhenCPFNonExist() {
        Assertions.assertDoesNotThrow(()-> {
            Optional<Employee> obj = repository.findByCpf(nonExistingCpf);
            Assertions.assertFalse(obj.isPresent());
        });
    }
    @Test
    public void findAllActives() {
        Assertions.assertDoesNotThrow(() -> {
            PageRequest pageRequest = PageRequest.of(0,12);
            Page<Employee> employees = repository.findAllActives(pageRequest);
            Assertions.assertEquals(7, employees.getTotalElements());
        });
    }
    @Test
    public void saveShouldCreateAndAutoincrementIdWhenIdIsNull() {
        Employee obj = Factory.createEmployee();
        obj.setId(null);
        obj = repository.save(obj);

        Assertions.assertNotNull(obj.getId());
        Assertions.assertEquals(countTotalIds+1, obj.getId());
    }

    @Test
    public void deleteShouldDeleteEmployeeWhenIdExists() {


        repository.deleteById(existingId);

        Optional<Employee> obj = repository.findById(existingId);
        Assertions.assertFalse(obj.isPresent());
    }

    @Test
    public void deleteShouldThrowEmptyResultDataAccessExceptionWhenIdDoesNotExist() {


        Assertions.assertThrows(EmptyResultDataAccessException.class,()->{
            repository.deleteById(nonExistingId);
        });
    }
}
