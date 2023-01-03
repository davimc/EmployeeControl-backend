package br.com.grupotsm.EmployeeControl.repositories;

import br.com.grupotsm.EmployeeControl.DTO.exchange.ExchangeDTO;
import br.com.grupotsm.EmployeeControl.entities.Exchange;
import br.com.grupotsm.EmployeeControl.entities.ExchangeTemporary;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;

@Repository
public interface ExchangeRepository extends JpaRepository<Exchange, Long> {
    @Query("SELECT obj " +
            "FROM Exchange obj " +
            "WHERE (:state = 0 OR :state = obj.state) " +
            "AND (:name IS NULL OR obj.employeeGenerator.name LIKE CONCAT(:name, '%'))" +
            "AND obj.dtStart BETWEEN :dtMin AND :dtMax")
    Page<Exchange> findAllActives(Pageable pageable, LocalDate dtMin, LocalDate dtMax, Integer state, String name);
    /*Query("SELECT obj " +
                  "FROM Exchange obj " +
                  "WHERE (:justActives = False OR" +
                  "((obj.dtEnd = null OR obj.dtEnd < CURRENT_DATE) AND (CURRENT_DATE <= obj.dtStart AND obj.dtExpected))) " +
                  "AND obj.dtStart BETWEEN :dtMin AND :dtMax")
    Page<ExchangeTemporary> findAllTemporaryActives*/

}
