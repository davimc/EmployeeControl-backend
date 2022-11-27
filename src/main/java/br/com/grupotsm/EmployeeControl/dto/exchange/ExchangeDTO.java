package br.com.grupotsm.EmployeeControl.dto.exchange;

import br.com.grupotsm.EmployeeControl.entities.Employee;
import br.com.grupotsm.EmployeeControl.entities.Exchange;
import br.com.grupotsm.EmployeeControl.entities.Store;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class ExchangeDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long id;
    private String generatorEmployee;
    private String exchangedEmployee;
    private String generatorStore;
    private String exchangedStore;
    private LocalDate dtStart;
    private LocalDate dtExpected;
    private LocalDate dtEnd;

    public ExchangeDTO() {
    }

    public ExchangeDTO(Long id, String generatorEmployee, String exchangedEmployee, String generatorStore, String exchangedStore, LocalDate dtStart, LocalDate dtExpected, LocalDate dtEnd, LocalDateTime created) {
        this.id = id;
        this.generatorEmployee = generatorEmployee;
        this.exchangedEmployee = exchangedEmployee;
        this.generatorStore = generatorStore;
        this.exchangedStore = exchangedStore;
        this.dtStart = dtStart;
        this.dtExpected = dtExpected;
        this.dtEnd = dtEnd;
    }
    public ExchangeDTO(Exchange obj) {
        id = obj.getId();
        generatorEmployee = obj.getGeneratorEmployee().getName();
        exchangedEmployee = obj.getExchangedEmployee().getName();
        generatorStore = obj.getGeneratorStore().getName();
        exchangedStore = obj.getExchangedStore().getName();
        dtStart = obj.getDtStart();
        dtExpected = obj.getDtExpected();
        dtEnd = obj.getDtEnd();
    }

    public Long getId() {
        return id;
    }

    public String getGeneratorEmployee() {
        return generatorEmployee;
    }

    public String getExchangedEmployee() {
        return exchangedEmployee;
    }

    public String getGeneratorStore() {
        return generatorStore;
    }

    public String getExchangedStore() {
        return exchangedStore;
    }

    public LocalDate getDtStart() {
        return dtStart;
    }

    public LocalDate getDtExpected() {
        return dtExpected;
    }

    public LocalDate getDtEnd() {
        return dtEnd;
    }
}
