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

    @Column(columnDefinition = "DATE")
    private LocalDate dtStart;
    @Column(columnDefinition = "DATE")
    private LocalDate dtExpected;
    @Column(columnDefinition = "DATE")
    private LocalDate dtEnd;

    public Exchange() {
    }

    public Exchange(Long id, Employee generatorEmployee, Store generatorStore, Store exchangedStore, LocalDate dtStart) {
        this.id = id;
        this.generatorEmployee = generatorEmployee;
        this.generatorStore = generatorStore;
        this.exchangedStore = exchangedStore;
        this.dtStart = dtStart;
    }
    public Exchange(Long id, Employee generatorEmployee, Store generatorStore, Store exchangedStore, LocalDate dtStart, LocalDate dtExpected) {
        this.id = id;
        this.generatorEmployee = generatorEmployee;
        this.generatorStore = generatorStore;
        this.exchangedStore = exchangedStore;
        this.dtStart = dtStart;
        this.dtExpected = dtExpected;
    }

    public Exchange(Long id, Employee generatorEmployee, Employee exchangedEmployee, Store generatorStore, Store exchangedStore, LocalDate dtStart) {
        this.id = id;
        this.generatorEmployee = generatorEmployee;
        this.exchangedEmployee = exchangedEmployee;
        this.generatorStore = generatorStore;
        this.exchangedStore = exchangedStore;
        this.dtStart = dtStart;
    }

    public Exchange(Long id, Employee generatorEmployee, Employee exchangedEmployee, Store generatorStore, Store exchangedStore, LocalDate dtStart, LocalDate dtExpected) {
        this.id = id;
        this.generatorEmployee = generatorEmployee;
        this.exchangedEmployee = exchangedEmployee;
        this.generatorStore = generatorStore;
        this.exchangedStore = exchangedStore;
        this.dtStart = dtStart;
        this.dtExpected = dtExpected;
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