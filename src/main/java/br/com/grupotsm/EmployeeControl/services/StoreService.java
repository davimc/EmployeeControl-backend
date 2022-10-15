package br.com.grupotsm.EmployeeControl.services;

import br.com.grupotsm.EmployeeControl.dto.StoreDTO;
import br.com.grupotsm.EmployeeControl.entities.Store;
import br.com.grupotsm.EmployeeControl.repositories.StoreRepository;
import br.com.grupotsm.EmployeeControl.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class StoreService {

    @Autowired
    private StoreRepository repository;

    public Page<StoreDTO> findAllPaged(Pageable pageable){
        Page<Store> stores = repository.findAll(pageable);
        return stores.map(StoreDTO::new);
    }

    public StoreDTO find(Long id) {
        Optional<Store> obj = repository.findById(id);
        return new StoreDTO(obj.orElseThrow(() -> new ObjectNotFoundException(id, Store.class)));
    }
}
