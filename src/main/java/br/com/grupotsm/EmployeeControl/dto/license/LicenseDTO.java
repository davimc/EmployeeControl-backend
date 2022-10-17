package br.com.grupotsm.EmployeeControl.dto.license;

import br.com.grupotsm.EmployeeControl.dto.employee.EmployeeDTO;
import br.com.grupotsm.EmployeeControl.entities.Employee;
import br.com.grupotsm.EmployeeControl.entities.License;

import javax.persistence.Column;
import java.time.LocalDate;

public class LicenseDTO {

    private Long id;
    private LocalDate dtStart;
    private LocalDate dtEnd;
    private String reason;
    private String description;
    private EmployeeDTO employee;

    public LicenseDTO() {
    }

    public LicenseDTO(Long id, LocalDate dtStart, LocalDate dtEnd, String reason, String description, EmployeeDTO employee) {
        this.id = id;
        this.dtStart = dtStart;
        this.dtEnd = dtEnd;
        this.reason = reason;
        this.description = description;
        this.employee = employee;
    }

    public LicenseDTO(License obj) {
        this.id = obj.getId();
        this.dtStart = obj.getDtStart();
        this.dtEnd = obj.getDtEnd();
        this.reason = obj.getReason().getDescription();
        this.description = obj.getDescription();
        this.employee = new EmployeeDTO(obj.getEmployee());
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public EmployeeDTO getEmployee() {
        return employee;
    }

    public void setEmployee(EmployeeDTO employee) {
        this.employee = employee;
    }
}
