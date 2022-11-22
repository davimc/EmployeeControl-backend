package br.com.grupotsm.EmployeeControl.repositories;

import br.com.grupotsm.EmployeeControl.entities.Shift;
import br.com.grupotsm.EmployeeControl.test.Factory;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.dao.EmptyResultDataAccessException;

import java.util.Optional;

@DataJpaTest
public class ShiftRepositoryTest {

    @Autowired
    private ShiftRepository repository;
    private long existingId;
    private long nonExistingId;
    private long dependentId;
    private long countTotalIds;

    @BeforeEach
    public void setUp() {
        existingId = 1L;
        nonExistingId = 1000L;
        dependentId = 4L;
        countTotalIds = repository.count();
    }

    @Test
    public void findByIdShouldReturnNonEmptyOptionalShiftWhenIdExists() {
        Assertions.assertDoesNotThrow(() -> {
            Optional<Shift> obj = repository.findById(existingId);
            Assertions.assertTrue(obj.isPresent());
            Assertions.assertEquals(obj.get().getId(), existingId);
        });
    }
    @Test
    public void findByIdShouldReturnEmptyOptionalShiftWhenIdDoesNotExist() {
        Assertions.assertDoesNotThrow(()-> {
            Optional<Shift> obj = repository.findById(nonExistingId);
            Assertions.assertFalse(obj.isPresent());
        });
    }
    @Test
    public void saveShouldCreateAndAutoincrementIdWhenIdIsNull() {
        Shift obj = Factory.createShift();
        obj.setId(null);
        obj = repository.save(obj);

        Assertions.assertNotNull(obj.getId());
        Assertions.assertEquals(countTotalIds+1, obj.getId());
    }

    @Test
    public void deleteShouldDeleteShiftWhenIdExists() {


        repository.deleteById(existingId);

        Optional<Shift> obj = repository.findById(existingId);
        Assertions.assertFalse(obj.isPresent());
    }

    @Test
    public void deleteShouldThrowEmptyResultDataAccessExceptionWhenIdDoesNotExist() {


        Assertions.assertThrows(EmptyResultDataAccessException.class,()->{
            repository.deleteById(nonExistingId);
        });
    }
}