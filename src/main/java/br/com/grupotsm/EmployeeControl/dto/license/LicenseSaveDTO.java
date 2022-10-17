package br.com.grupotsm.EmployeeControl.dto.license;

import br.com.grupotsm.EmployeeControl.entities.License;

import java.time.LocalDate;

public class LicenseSaveDTO {

    private LocalDate dtStart;
    private LocalDate dtEnd;
    private String reason;
    private String description;

    private Long employeeId;

    public LicenseSaveDTO() {
    }

    public LicenseSaveDTO(LocalDate dtStart, LocalDate dtEnd, String reason, String description, Long employeeId) {
        this.dtStart = dtStart;
        this.dtEnd = dtEnd;
        this.reason = reason;
        this.description = description;
        this.employeeId = employeeId;
    }

    public LicenseSaveDTO(License obj) {
        this.dtStart = obj.getDtStart();
        this.dtEnd = obj.getDtEnd();
        this.reason = obj.getReason().getDescription();
        this.description = obj.getDescription();
        this.employeeId = obj.getEmployee().getId();
    }

    public LocalDate getDtStart() {
        return dtStart;
    }

    public void setDtStart(LocalDate dtStart) {
        this.dtStart = dtStart;
    }

    public LocalDate getDtEnd() {
        return dtEnd;
    }

    public void setDtEnd(LocalDate dtEnd) {
        this.dtEnd = dtEnd;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
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
