package br.com.grupotsm.EmployeeControl.entities;

import br.com.grupotsm.EmployeeControl.entities.enums.LicenseType;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;

@Entity
@Table(name = "tb_license")
public class License implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(columnDefinition = "TIMESTAMP WITHOUT TIME ZONE")
    private LocalDate dtStart;
    @Column(columnDefinition = "TIMESTAMP WITHOUT TIME ZONE")
    private LocalDate dtEnd;
    private int type;

    @ManyToOne
    @JoinColumn(name = "employee_id")
    private Employee employee;

    public License() {
    }

    public License(Long id, LocalDate dtStart, LocalDate dtEnd, LicenseType type, Employee employee) {
        this.id = id;
        this.dtStart = dtStart;
        this.dtEnd = dtEnd;
        this.type = type.getPeriodSuggestion();
        this.employee = employee;
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

    public LicenseType getType() {
        return LicenseType.toEnum(type);
    }

    public void setType(LicenseType type) {
        this.type = type.getPeriodSuggestion();
    }

    public Employee getEmployee() {
        return employee;
    }
}
