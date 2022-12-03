package br.com.grupotsm.EmployeeControl.services;

import br.com.grupotsm.EmployeeControl.dto.exchange.ExchangeDTO;
import br.com.grupotsm.EmployeeControl.dto.exchange.ExchangeNewDTO;
import br.com.grupotsm.EmployeeControl.entities.Exchange;
import br.com.grupotsm.EmployeeControl.repositories.ExchangeRepository;
import br.com.grupotsm.EmployeeControl.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;



@Service
public class ExchangeService {

    @Autowired
    private ExchangeRepository repository;
    @Autowired
    private EmployeeService employeeService;
    @Autowired
    private StoreService storeService;

    @Transactional(readOnly = true)
    public Page<ExchangeDTO> findAllPaged(Pageable pageable){
        Page<Exchange> obj = repository.findAll(pageable);
        return obj.map(ExchangeDTO::new);
    }

    @Transactional(readOnly = true)
    protected Exchange findById(Long id) {
        Optional<Exchange> obj = repository.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException(id, Exchange.class));
    }
    @Transactional(readOnly = true)
    public ExchangeDTO findByIdDTO(Long id) {
        return new ExchangeDTO(findById(id));
    }

    /**
     * TODO verificar um jeito de dizer que a troca foi feita, está ocorrendo ou já foi encerrada
     * (essa última o dtEnd já faz o serviço.
     * Pensar em um jeito de fazr a dtStart fazer esse tratamento.
     * no entanto será preciso alguns cuidados.
     * caso dtStart seja atual, e tenha o funcionário, então a troca será realizada
     * mas se não, a troca será cancelada?
     * e se quiser para a troca ser cancelada antes? (permitir dtEnd ser antes da dtStart)
     **/
    @Transactional
    public ExchangeDTO create(ExchangeNewDTO dto) {
        Exchange obj = new Exchange();

        copyDtoToEntity(dto, obj);
        obj = repository.save(obj);

        return new ExchangeDTO(obj);
    }

    private void copyDtoToEntity(ExchangeNewDTO dto, Exchange obj) {
        obj.setDtStart(dto.getDtStart());
        obj.setDtExpected(dto.getDtExpected());
        obj.setGeneratorEmployee(employeeService.findById(dto.getGeneratorEmployeeId()));
        obj.setGeneratorStore(obj.getGeneratorEmployee().getStore());
        obj.setExchangedEmployee(employeeService.findById(dto.getExchangedEmployeeId()));
        obj.setExchangedStore(storeService.findById(dto.getExchangedStoreId()));
    }

   /* @Transactional
    public ExchangeDTO save(ExchangeNewDTO dto) {
        Exchange obj = new Exchange();

        copyDtoToEntity(dto, obj);
        obj.setCreated(LocalDateTime.now());
        obj = repository.save(obj);

        return new ExchangeDTO(obj);
    }

    @Transactional
    public ExchangeDTO update(Long id, ExchangeUpdateDTO dto) {
        Exchange obj = findById(id);

        copyDtoToEntity(dto, obj);
        obj.setUpdated(LocalDateTime.now());
        obj = repository.save(obj);

        return new ExchangeDTO(obj);
    }

    private void copyDtoToEntity(exchangeNewDTO dto, Exchange obj) {
        obj.setDescription(dto.getDescription());
        obj.setEmployee(employeeService.findById(dto.getEmployeeId()));
        obj.setDtStart(dto.getDtStart());
        obj.setDtExpected(dto.getDtExpected());
        obj.setReason(ReasonType.toEnum(dto.getReason()));
    }
    private void copyDtoToEntity(ExchangeUpdateDTO dto, Exchange obj) {
        obj.setDescription(dto.getDescription() == null? obj.getDescription() : dto.getDescription());
        obj.setEmployee(dto.getEmployeeId() == null ? obj.getEmployee() : employeeService.findById(dto.getEmployeeId()));
        obj.setDtStart(dto.getDtStart() == null ? obj.getDtStart() : dto.getDtStart());
        obj.setDtExpected(dto.getDtExpected() == null ? obj.getDtExpected() : dto.getDtExpected());
        obj.setDtEnd(dto.getDtEnd() == null ? obj.getDtEnd() : dto.getDtEnd());
        obj.setReason(dto.getReason() == null ? obj.getReason() : ReasonType.toEnum(dto.getReason()));
    }*/
}
