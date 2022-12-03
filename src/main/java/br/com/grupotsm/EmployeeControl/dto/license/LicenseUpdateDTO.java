package br.com.grupotsm.EmployeeControl.dto.license;

import br.com.grupotsm.EmployeeControl.entities.License;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.time.LocalDate;

//TODO criar dto para create
public class LicenseUpdateDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    private LocalDate dtStart;
    private LocalDate dtExpected;
    private LocalDate dtEnd;
    private Integer reason;
    private String description;
    private Long employeeId;

    public LicenseUpdateDTO() {
    }

    public LicenseUpdateDTO(LocalDate dtStart, LocalDate dtExpected, LocalDate dtEnd, Integer reason, String description, Long employeeId) {
        this.dtStart = dtStart;
        this.dtExpected = dtExpected;
        this.dtEnd = dtEnd;
        this.reason = reason;
        this.description = description;
        this.employeeId = employeeId;
    }

    public LicenseUpdateDTO(License obj) {
        dtStart = obj.getDtStart();
        dtExpected = obj.getDtExpected();
        dtEnd = obj.getDtEnd();
        reason = obj.getReason().getPeriodSuggestion();
        description = obj.getDescription();
        employeeId = obj.getEmployee().getId();
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

    public Integer getReason() {
        return reason;
    }

    public void setReason(Integer reason) {
        this.reason = reason;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Long employeeId) {
        this.employeeId = employeeId;
    }
}
