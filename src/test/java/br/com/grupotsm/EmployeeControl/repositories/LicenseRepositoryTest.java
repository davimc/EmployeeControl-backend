package br.com.grupotsm.EmployeeControl.repositories;

import br.com.grupotsm.EmployeeControl.entities.License;
import br.com.grupotsm.EmployeeControl.test.Factory;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.dao.EmptyResultDataAccessException;

import java.util.Optional;

@DataJpaTest
public class LicenseRepositoryTest {

    @Autowired
    private LicenseRepository repository;
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
    public void findByIdShouldReturnNonEmptyOptionalLicenseWhenIdExists() {
        Assertions.assertDoesNotThrow(() -> {
            Optional<License> obj = repository.findById(existingId);
            Assertions.assertTrue(obj.isPresent());
            Assertions.assertEquals(obj.get().getId(), existingId);
        });
    }
    @Test
    public void findByIdShouldReturnEmptyOptionalLicenseWhenIdDoesNotExist() {
        Assertions.assertDoesNotThrow(()-> {
            Optional<License> obj = repository.findById(nonExistingId);
            Assertions.assertFalse(obj.isPresent());
        });
    }
    @Test
    public void saveShouldCreateAndAutoincrementIdWhenIdIsNull() {
        License obj = Factory.createLicense();
        obj.setId(null);
        obj = repository.save(obj);

        Assertions.assertNotNull(obj.getId());
        Assertions.assertEquals(countTotalIds+1, obj.getId());
    }

    @Test
    public void deleteShouldDeleteLicenseWhenIdExists() {


        repository.deleteById(existingId);

        Optional<License> obj = repository.findById(existingId);
        Assertions.assertFalse(obj.isPresent());
    }

    @Test
    public void deleteShouldThrowEmptyResultDataAccessExceptionWhenIdDoesNotExist() {


        Assertions.assertThrows(EmptyResultDataAccessException.class,()->{
            repository.deleteById(nonExistingId);
        });
    }
}
