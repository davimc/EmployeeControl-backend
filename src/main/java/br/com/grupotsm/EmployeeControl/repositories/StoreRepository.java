package br.com.grupotsm.EmployeeControl.repositories;

import br.com.grupotsm.EmployeeControl.entities.Store;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StoreRepository extends JpaRepository<Store, Long> {
}