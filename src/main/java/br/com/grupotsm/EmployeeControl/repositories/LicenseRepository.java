package br.com.grupotsm.EmployeeControl.repositories;

import br.com.grupotsm.EmployeeControl.entities.License;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


@Repository
public interface LicenseRepository extends JpaRepository<License, Long> {
    @Query("SELECT obj FROM License obj " +
            "WHERE (:justActives = False OR CURRENT_DATE BETWEEN obj.dtStart AND obj.dtExpected)")
    Page<License> findAllActives(Pageable pageable, boolean justActives);
}
