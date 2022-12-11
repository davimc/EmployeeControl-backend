package br.com.grupotsm.EmployeeControl.repositories;

import br.com.grupotsm.EmployeeControl.DTO.store.StoreExpandedDTO;
import br.com.grupotsm.EmployeeControl.entities.Store;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface StoreRepository extends JpaRepository<Store, Long> {
}
