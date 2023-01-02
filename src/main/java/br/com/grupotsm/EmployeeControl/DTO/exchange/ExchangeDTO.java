package br.com.grupotsm.EmployeeControl.DTO.exchange;

import br.com.grupotsm.EmployeeControl.DTO.employee.EmployeeShortDTO;
import br.com.grupotsm.EmployeeControl.DTO.request.RequestDTO;
import br.com.grupotsm.EmployeeControl.entities.Exchange;
import br.com.grupotsm.EmployeeControl.entities.ExchangeTemporary;
import br.com.grupotsm.EmployeeControl.entities.enums.ExpedientType;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

public class ExchangeDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private long id;

    private LocalDateTime createdAt;
    private LocalDate dtStart;
    private LocalDate dtExpected;
    private LocalDate dtEnd;
    private ExpedientType expedient;
    private EmployeeShortDTO employeeGenerator;
    private EmployeeShortDTO employeeExchanged;
    private List<RequestDTO> requests;

    public ExchangeDTO() {
    }

    public ExchangeDTO(long id, LocalDateTime createdAt, LocalDate dtStart, LocalDate dtExpected, LocalDate dtEnd, ExpedientType expedient, EmployeeShortDTO employeeGenerator, EmployeeShortDTO employeeExchanged, List<RequestDTO> requests) {
        this.id = id;
        this.createdAt = createdAt;
        this.dtStart = dtStart;
        this.dtExpected = dtExpected;
        this.dtEnd = dtEnd;
        this.expedient = expedient;
        this.employeeGenerator = employeeGenerator;
        this.employeeExchanged = employeeExchanged;
        this.requests = requests;
    }
    public ExchangeDTO(Exchange obj){
        id = obj.getId();
        createdAt = obj.getCreatedAt();
        dtStart = obj.getDtStart();
        expedient = obj.getExpedient();
        employeeGenerator = new EmployeeShortDTO(obj.getEmployeeGenerator());
        employeeExchanged = new EmployeeShortDTO(obj.getEmployeeExchanged());
        requests = obj.getRequests().stream().map(RequestDTO::new).collect(Collectors.toList());
        if(obj instanceof ExchangeTemporary) {
            ExchangeTemporary tempObj = (ExchangeTemporary) obj;
            dtExpected = tempObj.getDtExpected();
            dtEnd = tempObj.getDtEnd();
        }
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
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

    public LocalDate getDtEnd() {
        return dtEnd;
    }

    public void setDtEnd(LocalDate dtEnd) {
        this.dtEnd = dtEnd;
    }

    public ExpedientType getExpedient() {
        return expedient;
    }

    public void setExpedient(ExpedientType expedient) {
        this.expedient = expedient;
    }

    public EmployeeShortDTO getEmployeeGenerator() {
        return employeeGenerator;
    }

    public void setEmployeeGenerator(EmployeeShortDTO employeeGenerator) {
        this.employeeGenerator = employeeGenerator;
    }

    public EmployeeShortDTO getEmployeeExchanged() {
        return employeeExchanged;
    }

    public void setEmployeeExchanged(EmployeeShortDTO employeeExchanged) {
        this.employeeExchanged = employeeExchanged;
    }

    public List<RequestDTO> getRequests() {
        return requests;
    }

}
