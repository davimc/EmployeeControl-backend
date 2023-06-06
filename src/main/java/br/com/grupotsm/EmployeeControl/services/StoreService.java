package br.com.grupotsm.EmployeeControl.services;

import br.com.grupotsm.EmployeeControl.DTO.store.StoreNewDTO;
import br.com.grupotsm.EmployeeControl.DTO.store.StoreDTO;
import br.com.grupotsm.EmployeeControl.DTO.store.StoreUpdateDTO;
import br.com.grupotsm.EmployeeControl.entities.Store;
import br.com.grupotsm.EmployeeControl.entities.enums.StoreType;
import br.com.grupotsm.EmployeeControl.repositories.StoreRepository;
import br.com.grupotsm.EmployeeControl.services.exceptions.DatabaseException;
import br.com.grupotsm.EmployeeControl.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;


@Service
public class StoreService {
    
    @Autowired
    private StoreRepository repository;

    @Transactional(readOnly = true)
    private Store findById(Long id) {
        return repository.findById(id).orElseThrow(() -> new ObjectNotFoundException(id, Store.class));
    }
    @Transactional(readOnly = true)
    public List<StoreDTO> findStores(String name, Integer type) {
        List<Store> obj = repository.findByNameOrType(name, type);
        return obj.stream().map(StoreDTO::new).collect(Collectors.toList());
    }
    @Transactional(readOnly = true)
    public StoreDTO findExpanded(Long id) {
        Store obj = findById(id);

        return new StoreDTO(obj);
    }

    public List<StoreType> getTypes() {
        return Arrays.stream(StoreType.values()).toList();
    }

    public StoreDTO insert(StoreNewDTO newDTO) {
        Store obj = newDTO.toModel();

        obj = repository.save(obj);
        return new StoreDTO(obj);
    }

    public StoreUpdateDTO update(Long id, StoreUpdateDTO dto) {
        Store obj = findById(id);
        dto.toModel(obj);
        obj = repository.save(obj);

        return new StoreUpdateDTO(obj);
    }

    public void delete(Long id) {
        try {
            Store obj = findById(id);
            repository.delete(obj);
        }catch (DataIntegrityViolationException e) {
            throw new DatabaseException("There is a dependency");
        }
    }
}
