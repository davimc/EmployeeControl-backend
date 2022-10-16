package br.com.grupotsm.EmployeeControl.repositories;

import br.com.grupotsm.EmployeeControl.entities.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}
