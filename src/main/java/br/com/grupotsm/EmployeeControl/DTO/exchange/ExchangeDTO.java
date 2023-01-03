package br.com.grupotsm.EmployeeControl.DTO.exchange;

import br.com.grupotsm.EmployeeControl.DTO.employee.EmployeeShortDTO;
import br.com.grupotsm.EmployeeControl.DTO.request.RequestDTO;
import br.com.grupotsm.EmployeeControl.entities.Exchange;
import br.com.grupotsm.EmployeeControl.entities.ExchangeTemporary;
import br.com.grupotsm.EmployeeControl.entities.enums.ExpedientType;
import br.com.grupotsm.EmployeeControl.entities.enums.ExchangeState;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public class ExchangeDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private long id;
    private LocalDateTime createdAt;
    private LocalDate dtStart;
    private LocalDate dtExpected;
    private LocalDate dtEnd;
    private ExpedientType expedient;
    private ExchangeState state;
    private EmployeeShortDTO employeeGenerator;
    private EmployeeShortDTO employeeExchanged;
    private List<RequestDTO> requests;

    public ExchangeDTO() {
    }

    public ExchangeDTO(long id, LocalDateTime createdAt, LocalDate dtStart, LocalDate dtExpected, LocalDate dtEnd, ExpedientType expedient, ExchangeState state, EmployeeShortDTO employeeGenerator, EmployeeShortDTO employeeExchanged, List<RequestDTO> requests) {
        this.id = id;
        this.createdAt = createdAt;
        this.dtStart = dtStart;
        this.dtExpected = dtExpected;
        this.dtEnd = dtEnd;
        this.expedient = expedient;
        this.state = state;
        this.employeeGenerator = employeeGenerator;
        this.employeeExchanged = employeeExchanged;
        this.requests = requests;
    }
    public ExchangeDTO(Exchange obj) {
        this.id = obj.getId();
        this.createdAt = obj.getCreatedAt();
        this.dtStart = obj.getDtStart();
        this.expedient = obj.getExpedient();
        this.state = obj.getState();
        this.employeeGenerator = new EmployeeShortDTO(obj.getEmployeeGenerator());
        this.employeeExchanged = obj.getEmployeeExchanged() != null ? new EmployeeShortDTO(obj.getEmployeeExchanged()): null;
        this.requests = requests;
        if(obj instanceof ExchangeTemporary) {
            this.dtExpected = ((ExchangeTemporary) obj).getDtExpected();
            this.dtEnd = ((ExchangeTemporary) obj).getDtEnd();
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

    public String getExpedient() {
        return expedient.getDescription();
    }

    public void setExpedient(ExpedientType expedient) {
        this.expedient = expedient;
    }

    public String getState() {
        return state.getName();
    }

    public void setState(ExchangeState state) {
        this.state = state;
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

    public void setRequests(List<RequestDTO> requests) {
        this.requests = requests;
    }
}
