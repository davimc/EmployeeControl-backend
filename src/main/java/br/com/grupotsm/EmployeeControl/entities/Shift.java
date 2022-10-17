package br.com.grupotsm.EmployeeControl.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;


@Entity
@Table(name = "tb_shift")
public class Shift implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDate dtStart;
    private LocalDate dtEnd;

    private Store store;
    private Employee generatingEmployee;
    private Employee assignedEmployee;

    private License license;

    public Shift(Long id, LocalDate dtStart, LocalDate dtEnd, Store store, Employee generatingEmployee, Employee assignedEmployee) {
        this.id = id;
        this.dtStart = dtStart;
        this.dtEnd = dtEnd;
        this.store = store;
        this.generatingEmployee = generatingEmployee;
        this.assignedEmployee = assignedEmployee;
    }

    public Shift(Long id, LocalDate dtStart, LocalDate dtEnd, Store store, Employee generatingEmployee, Employee assignedEmployee, License license) {
        this.id = id;
        this.dtStart = dtStart;
        this.dtEnd = dtEnd;
        this.store = store;
        this.generatingEmployee = generatingEmployee;
        this.assignedEmployee = assignedEmployee;
        this.license = license;
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

    public Store getStore() {
        return store;
    }

    public void setStore(Store store) {
        this.store = store;
    }

    public Employee getGeneratingEmployee() {
        return generatingEmployee;
    }

    public void setGeneratingEmployee(Employee generatingEmployee) {
        this.generatingEmployee = generatingEmployee;
    }

    public Employee getAssignedEmployee() {
        return assignedEmployee;
    }

    public void setAssignedEmployee(Employee assignedEmployee) {
        this.assignedEmployee = assignedEmployee;
    }

    public License getLicense() {
        return license;
    }

    public void setLicense(License license) {
        this.license = license;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Shift shift = (Shift) o;
        return id.equals(shift.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
