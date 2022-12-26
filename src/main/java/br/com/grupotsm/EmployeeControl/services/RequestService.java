package br.com.grupotsm.EmployeeControl.services;

import br.com.grupotsm.EmployeeControl.DTO.request.RequestDTO;
import br.com.grupotsm.EmployeeControl.entities.Employee;
import br.com.grupotsm.EmployeeControl.entities.Exchange;
import br.com.grupotsm.EmployeeControl.entities.Request;
import br.com.grupotsm.EmployeeControl.repositories.ExchangeRepository;
import br.com.grupotsm.EmployeeControl.repositories.RequestRepository;
import br.com.grupotsm.EmployeeControl.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;


@Service
public class RequestService {
    @Autowired
    private RequestRepository repository;

    //todo mudar para exchange service
    @Autowired ExchangeRepository exchangeRepository;

    @Transactional(readOnly = true)
    public List<RequestDTO> findAll() {
        List<Request> obj = repository.findAll();

        return obj.stream().map(RequestDTO::new).collect(Collectors.toList());
    }
    @Transactional(readOnly = true)
    public RequestDTO findById(Long id) {
        Request obj = repository.findById(id).orElseThrow(() -> {
            throw new ObjectNotFoundException(id, Employee.class);
        });
        return new RequestDTO(obj);
    }

    public List<RequestDTO> findByExchange(Long idExchange) {
        Exchange ex = exchangeRepository.findById(idExchange).get();
        List<Request> obj = repository.findByExchange(ex);
        return obj.stream().map(RequestDTO::new).collect(Collectors.toList());
    }
}
