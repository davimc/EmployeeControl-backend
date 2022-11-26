package br.com.grupotsm.EmployeeControl.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@Table(name = "tb_exchange")
public class Exchange implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "generator_employee_id")
    private Employee generatorEmployee;
    @ManyToOne
    @JoinColumn(name = "exchanged_employee_id")
    private Employee exchangedEmployee;
    @ManyToOne
    @JoinColumn(name = "generator_store_id")
    private Store generatorStore;
    @ManyToOne
    @JoinColumn(name = "exchanged_store_id")
    private Store exchangedStore;

    @Column(columnDefinition = "TIMESTAMP WITHOUT TIME ZONE")
    private LocalDateTime created;
    @Column(columnDefinition = "TIMESTAMP WITHOUT TIME ZONE")
    private LocalDateTime updated;

    @Column(columnDefinition = "TIMESTAMP WITHOUT TIME ZONE")
    private LocalDate dtStart;
    @Column(columnDefinition = "TIMESTAMP WITHOUT TIME ZONE")
    private LocalDate dtExpected;
    @Column(columnDefinition = "TIMESTAMP WITHOUT TIME ZONE")
    private LocalDate dtEnd;
    private boolean active;

    public Exchange() {
    }

    public Exchange(Long id, Employee generatorEmployee, Store generatorStore, Store exchangedStore, LocalDate dtStart) {
        this.id = id;
        this.generatorEmployee = generatorEmployee;
        this.generatorStore = generatorStore;
        this.exchangedStore = exchangedStore;
        this.dtStart = dtStart;
        this.active = true;
    }
    public Exchange(Long id, Employee generatorEmployee, Store generatorStore, Store exchangedStore, LocalDate dtStart, LocalDate dtExpected) {
        this.id = id;
        this.generatorEmployee = generatorEmployee;
        this.generatorStore = generatorStore;
        this.exchangedStore = exchangedStore;
        this.dtStart = dtStart;
        this.dtExpected = dtExpected;
        this.active = true;
    }

    public Exchange(Long id, Employee generatorEmployee, Employee exchangedEmployee, Store generatorStore, Store exchangedStore, LocalDate dtStart) {
        this.id = id;
        this.generatorEmployee = generatorEmployee;
        this.exchangedEmployee = exchangedEmployee;
        this.generatorStore = generatorStore;
        this.exchangedStore = exchangedStore;
        this.dtStart = dtStart;
        this.active = true;
    }

    public Exchange(Long id, Employee generatorEmployee, Employee exchangedEmployee, Store generatorStore, Store exchangedStore, LocalDate dtStart, LocalDate dtExpected) {
        this.id = id;
        this.generatorEmployee = generatorEmployee;
        this.exchangedEmployee = exchangedEmployee;
        this.generatorStore = generatorStore;
        this.exchangedStore = exchangedStore;
        this.dtStart = dtStart;
        this.dtExpected = dtExpected;
        this.active = true;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Employee getGeneratorEmployee() {
        return generatorEmployee;
    }

    public void setGeneratorEmployee(Employee generatorEmployee) {
        this.generatorEmployee = generatorEmployee;
    }

    public Employee getExchangedEmployee() {
        return exchangedEmployee;
    }

    public void setExchangedEmployee(Employee exchangedEmployee) {
        this.exchangedEmployee = exchangedEmployee;
    }

    public Store getGeneratorStore() {
        return generatorStore;
    }

    public void setGeneratorStore(Store generatorStore) {
        this.generatorStore = generatorStore;
    }

    public Store getExchangedStore() {
        return exchangedStore;
    }

    public void setExchangedStore(Store exchangedStore) {
        this.exchangedStore = exchangedStore;
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

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
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