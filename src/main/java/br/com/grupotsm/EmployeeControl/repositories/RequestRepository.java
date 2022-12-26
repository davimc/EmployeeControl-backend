package br.com.grupotsm.EmployeeControl.repositories;

import br.com.grupotsm.EmployeeControl.entities.Exchange;
import br.com.grupotsm.EmployeeControl.entities.Request;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;


@Repository
public interface RequestRepository extends JpaRepository<Request, Long> {
    List<Request> findByExchange(Exchange exchange);
}
