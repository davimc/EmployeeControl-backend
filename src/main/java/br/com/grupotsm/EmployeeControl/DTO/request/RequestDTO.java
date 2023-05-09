package br.com.grupotsm.EmployeeControl.DTO.request;

import br.com.grupotsm.EmployeeControl.DTO.employee.EmployeeShortDTO;
import br.com.grupotsm.EmployeeControl.entities.Exchange;
import br.com.grupotsm.EmployeeControl.entities.Request;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class RequestDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    private Long id;
    private LocalDateTime createdAt;
    private LocalDate dtStart;
    private LocalDate dtExpected;
    private LocalDate dtEnd;
    private String state;

    private String employee;

    public RequestDTO() {
    }

    public RequestDTO(Long id, LocalDateTime createdAt, LocalDate dtStart, LocalDate dtExpected, LocalDate dtEnd, String state, String employee) {
        this.id = id;
        this.createdAt = createdAt;
        this.dtStart = dtStart;
        this.dtExpected = dtExpected;
        this.dtEnd = dtEnd;
        this.state = state;
        this.employee = employee;
    }
    public RequestDTO(Request obj) {
        this.id = obj.getId();
        this.createdAt = obj.getCreatedAt();
        this.dtStart = obj.getDtAcceptedStart() == null? obj.getDtProposedStart(): obj.getDtAcceptedStart();
        this.dtExpected = obj.getDtAcceptedEnd() == null? obj.getDtProposedEnd() : obj.getDtAcceptedEnd();
        this.dtEnd = obj.getDtEnd();
        this.state = obj.getState().getDescription();
        employee = obj.getEmployee().getName();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getEmployee() {
        return employee;
    }

    public void setEmployee(String employee) {
        this.employee = employee;
    }
}
