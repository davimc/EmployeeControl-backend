package br.com.grupotsm.EmployeeControl.services;

import br.com.grupotsm.EmployeeControl.DTO.store.StoreDTO;
import br.com.grupotsm.EmployeeControl.DTO.store.StoreExpandedDTO;
import br.com.grupotsm.EmployeeControl.entities.Store;
import br.com.grupotsm.EmployeeControl.repositories.StoreRepository;
import br.com.grupotsm.EmployeeControl.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Service
public class StoreService {
    
    @Autowired
    private StoreRepository repository;

    @Transactional(readOnly = true)
    public List<StoreDTO> findAll() {
        List<Store> obj = repository.findAll();
        return obj.stream().map(StoreDTO::new).collect(Collectors.toList());
    }
    @Transactional(readOnly = true)
    public StoreExpandedDTO findExpanded(Long id) {
        Optional<Store> obj = repository.findById(id);
        Optional<StoreExpandedDTO> dto = obj.map(StoreExpandedDTO::new);
        return dto.orElseThrow(() -> {
            throw new ObjectNotFoundException(id, Store.class);
        });
    }

}
