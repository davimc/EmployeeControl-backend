package br.com.grupotsm.EmployeeControl.repositories;

import br.com.grupotsm.EmployeeControl.entities.License;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.Optional;

@Repository
public interface LicenseRepository extends JpaRepository<License, Long> {

    @Query("SELECT obj FROM License obj " +
            "WHERE obj.employee.id = :employeeId AND (obj.dtEnd >= :data AND obj.dtStart <= :data)")
    Optional<License> findActiveLicenseByEmployee(long employeeId, LocalDate data);
}
