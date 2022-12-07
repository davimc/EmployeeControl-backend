package br.com.grupotsm.EmployeeControl.repositories;

import br.com.grupotsm.EmployeeControl.entities.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    Optional<Employee> findByCpf(String cpf);

    // TODO Refatorar essa pesquisa para buscar nas licenças
    @Query("SELECT obj FROM Employee obj " +
            "WHERE (:isActive = false OR obj.dtResignation IS NULL) " +
            "OR :isAvailable = true")
    Page<Employee> findAll(Pageable pageable, boolean isActive, boolean isAvailable);
}
