package br.com.grupotsm.EmployeeControl.entities;

import br.com.grupotsm.EmployeeControl.entities.enums.ReasonType;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@Table(name = "tb_license")
public class License implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(columnDefinition = "DATE")
    private LocalDate dtStart;
    @Column(columnDefinition = "DATE")
    private LocalDate dtExpected;
    @Column(columnDefinition = "DATE")
    private LocalDate dtEnd;
    private int reason;
    private String description;

    @ManyToOne
    @JoinColumn(name = "employee_id")
    private Employee employee;

    @Column(columnDefinition = "TIMESTAMP WITHOUT TIME ZONE")
    private LocalDateTime created;
    @Column(columnDefinition = "TIMESTAMP WITHOUT TIME ZONE")
    private LocalDateTime updated;

    public License() {
    }

    public License(Long id, LocalDate dtStart, LocalDate dtExpected, ReasonType reason, String description, Employee employee) {
        this.id = id;
        this.dtStart = dtStart;
        this.dtExpected = dtExpected;
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

    public LocalDate getDtExpected() {
        return dtExpected;
    }

    public void setDtExpected(LocalDate dtExpected) {
        this.dtExpected = dtExpected;
    }

    public ReasonType getReason() {
        return ReasonType.toEnum(reason);
    }

    public void setReason(ReasonType reason) {
        this.reason = reason.getPeriodSuggestion();
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public Employee getEmployee() {
        return employee;
    }
    public LocalDateTime getCreated() {
        return created;
    }

    public void setCreated(LocalDateTime created) {
        this.created = created;
    }

    public LocalDateTime getUpdated() {
        return updated;
    }

    public void setUpdated(LocalDateTime updated) {
        this.updated = updated;
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
