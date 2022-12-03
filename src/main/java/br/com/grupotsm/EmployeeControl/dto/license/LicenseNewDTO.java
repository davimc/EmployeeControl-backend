package br.com.grupotsm.EmployeeControl.dto.license;

import br.com.grupotsm.EmployeeControl.entities.License;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.time.LocalDate;
//TODO criar dto para create
public class LicenseNewDTO implements Serializable {
    private static final long serialVersionUID = 1L;


    @NotNull(message = "Data de início não pode ser vazia")
    private LocalDate dtStart;
    @NotNull(message = "Data de prevista não pode ser vazia")
    private LocalDate dtExpected;

    @NotNull(message = "É necessário informar um motivo")
    private Integer reason;
    @Size(max = 255, message = "Ultrapassou o limite de texto")
    private String description;

    @NotNull(message = "É necessário informar o funcionário designado")
    private Long employeeId;

    public LicenseNewDTO() {
    }

    public LicenseNewDTO(LocalDate dtStart, LocalDate dtExpected, int reason, String description, Long employeeId) {
        this.dtStart = dtStart;
        this.dtExpected = dtExpected;
        this.reason = reason;
        this.description = description;
        this.employeeId = employeeId;
    }

    public LicenseNewDTO(License obj) {
        this.dtStart = obj.getDtStart();
        this.dtExpected = obj.getDtExpected();
        this.reason = obj.getReason().getPeriodSuggestion();
        this.description = obj.getDescription();
        this.employeeId = obj.getEmployee().getId();
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

    public int getReason() {
        return reason;
    }

    public void setReason(int reason) {
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
