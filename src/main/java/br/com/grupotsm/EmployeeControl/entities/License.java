package br.com.grupotsm.EmployeeControl.entities;

import br.com.grupotsm.EmployeeControl.entities.enums.ReasonType;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

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
    private int reason;
    private String description;

    @ManyToOne
    @JoinColumn(name = "employee_id")
    private Employee employee;

    public License() {
    }

    public License(Long id, LocalDate dtStart, LocalDate dtEnd, ReasonType reason, String description, Employee employee) {
        this.id = id;
        this.dtStart = dtStart;
        this.dtEnd = dtEnd;
        this.reason = reason.getPeriodSuggestion();
        this.description = description;
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

    public ReasonType getReason() {
        return ReasonType.toEnum(reason);
    }

    public void setReason(ReasonType reason) {
        this.reason = reason.getPeriodSuggestion();
    }

    public Employee getEmployee() {
        return employee;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        License license = (License) o;
        return id.equals(license.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
