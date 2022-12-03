package br.com.grupotsm.EmployeeControl.dto.exchange;

import br.com.grupotsm.EmployeeControl.entities.Exchange;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class ExchangeNewDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    @NotNull(message = "Funcionário que gerou deve ser informado")
    private Long generatorEmployeeId;
    private Long exchangedEmployeeId;
    private Long exchangedStoreId;
    @NotNull(message = "Data de início deve ser informada")
    private LocalDate dtStart;
    @NotNull(message = "Data prevista deve ser informada")
    private LocalDate dtExpected;

    public ExchangeNewDTO() {
    }

    public ExchangeNewDTO(Long generatorEmployee, Long exchangedEmployee, Long generatorStore, Long exchangedStore, LocalDate dtStart, LocalDate dtExpected, LocalDateTime created) {
        this.generatorEmployeeId = generatorEmployee;
        this.exchangedEmployeeId = exchangedEmployee;
        this.exchangedStoreId = exchangedStore;
        this.dtStart = dtStart;
        this.dtExpected = dtExpected;
    }
    public ExchangeNewDTO(Exchange obj) {
        generatorEmployeeId = obj.getGeneratorEmployee().getId();
        exchangedEmployeeId = obj.getExchangedEmployee().getId();

        exchangedStoreId = obj.getExchangedStore().getId();
        dtStart = obj.getDtStart();
        dtExpected = obj.getDtExpected();
    }

    public Long getGeneratorEmployeeId() {
        return generatorEmployeeId;
    }

    public void setGeneratorEmployeeId(Long generatorEmployeeId) {
        this.generatorEmployeeId = generatorEmployeeId;
    }

    public Long getExchangedEmployeeId() {
        return exchangedEmployeeId;
    }

    public void setExchangedEmployeeId(Long exchangedEmployeeId) {
        this.exchangedEmployeeId = exchangedEmployeeId;
    }

    public Long getExchangedStoreId() {
        return exchangedStoreId;
    }

    public void setExchangedStoreId(Long exchangedStoreId) {
        this.exchangedStoreId = exchangedStoreId;
    }

    public LocalDate getDtStart() {
        return dtStart;
    }

    public void setDtStart(LocalDate dtStart) {
        this.dtStart = dtStart;
    }

    public LocalDate getDtExpected() {
        return dtExpected;
    }

    public void setDtExpected(LocalDate dtExpected) {
        this.dtExpected = dtExpected;
    }
}
