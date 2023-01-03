package br.com.grupotsm.EmployeeControl.services;

import br.com.grupotsm.EmployeeControl.DTO.exchange.ExchangeDTO;
import br.com.grupotsm.EmployeeControl.entities.Employee;
import br.com.grupotsm.EmployeeControl.entities.Exchange;
import br.com.grupotsm.EmployeeControl.repositories.ExchangeRepository;
import br.com.grupotsm.EmployeeControl.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;


@Service
public class ExchangeService {
    @Autowired
    private ExchangeRepository repository;

    @Transactional(readOnly = true)
    public Page<ExchangeDTO> findAllActives(Pageable pageable, String min, String max, Integer state, String name) {
        LocalDate dtMin = min.equals("") ? LocalDate.now().minusYears(1)
                : LocalDate.parse(min);
        LocalDate dtMax = max.equals("") ? LocalDate.now()
                : LocalDate.parse(max);
        return repository.findAllActives(pageable, dtMin, dtMax, state, name)
                .map(ExchangeDTO::new);
    }
    @Transactional(readOnly = true)
    public ExchangeDTO findById(Long id) {
        Exchange obj = repository.findById(id).orElseThrow(() -> {
            throw new ObjectNotFoundException(id, Employee.class);
        });
        return new ExchangeDTO(obj);
    }
}
