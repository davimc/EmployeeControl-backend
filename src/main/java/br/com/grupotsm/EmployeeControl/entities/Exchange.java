package br.com.grupotsm.EmployeeControl.entities;

import br.com.grupotsm.EmployeeControl.entities.enums.ExpedientType;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@Table(name = "tb_exchange")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class Exchange implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @TableGenerator(table = "SEQUENCES", name = "ConfirmationCodeGenerator")
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "ConfirmationCodeGenerator")
    private Long id;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private LocalDate dtStart;

    private Integer expedient;

    @ManyToOne()
    @JoinColumn(name = "employee_generator_id")
    private Employee employeeGenerator;
    @ManyToOne()
    @JoinColumn(name = "employee_exchanged_id")
    private Employee employeeExchanged;

    public Exchange() {
    }

    public Exchange(Long id, LocalDate dtStart, ExpedientType expedient, Employee employeeGenerator, Employee employeeExchanged) {
        this.id = id;
        this.dtStart = dtStart;
        this.expedient = expedient.getCod();
        this.employeeGenerator = employeeGenerator;
        this.employeeExchanged = employeeExchanged;
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

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

    public LocalDate getDtStart() {
        return dtStart;
    }

    public void setDtStart(LocalDate dtStart) {
        this.dtStart = dtStart;
    }

    public ExpedientType getExpedient() {
        return ExpedientType.toEnum(expedient);
    }

    public void setExpedient(ExpedientType expedient) {
        this.expedient = expedient.getCod();
    }

    public Employee getEmployeeGenerator() {
        return employeeGenerator;
    }

    public void setEmployeeGenerator(Employee employeeGenerator) {
        this.employeeGenerator = employeeGenerator;
    }

    public Employee getEmployeeExchanged() {
        return employeeExchanged;
    }

    public void setEmployeeExchanged(Employee employeeExchanged) {
        this.employeeExchanged = employeeExchanged;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Exchange exchange = (Exchange) o;
        return id.equals(exchange.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
