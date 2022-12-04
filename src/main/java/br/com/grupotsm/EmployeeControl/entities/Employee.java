package br.com.grupotsm.EmployeeControl.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.*;

@Entity
@Table(name = "tb_employee")
public class Employee implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    @Column(length = 1)
    private char gender;
    private String email;
    private String cpf;
    @Column(columnDefinition = "DATE")
    private LocalDate dtAdmission;
    @Column(columnDefinition = "DATE")
    private LocalDate dtResignation;
    @Column(columnDefinition = "DATE")
    private LocalDate birthDate;

    @ManyToOne
    @JoinColumn(name = "store_origin_id")
    private Store storeOrigin;
    @ManyToOne
    @JoinColumn(name = "store_current_id")
    private Store storeCurrent;

    /*@OneToMany(mappedBy = "employee")
    private Set<License> licenses = new HashSet<>();
*/
    @Column(columnDefinition = "TIMESTAMP WITHOUT TIME ZONE")
    private LocalDateTime created;
    @Column(columnDefinition = "TIMESTAMP WITHOUT TIME ZONE")
    private LocalDateTime updated;
    /*@OneToMany(mappedBy = "generatorEmployee")
    private List<Exchange> generatedExchanges = new ArrayList<>();
    @OneToMany(mappedBy = "exchangedEmployee")
    private List<Exchange> receivedExchanges = new ArrayList<>();*/
    public Employee() {
    }

    public Employee(Long id, String name, char gender, String email, String cpf, LocalDate dtAdmission, LocalDate birthDate, Store store) {
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.email = email;
        this.cpf = cpf;
        this.dtAdmission = dtAdmission;
        this.birthDate = birthDate;
        this.storeOrigin = store;
        this.storeCurrent = store;
    }

    public Employee(Long id, String name, char gender, String email, String cpf, LocalDate dtAdmission, LocalDate dtResignation, LocalDate birthDate, Store storeOrigin, Store storeCurrent) {
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.email = email;
        this.cpf = cpf;
        this.dtAdmission = dtAdmission;
        this.dtResignation = dtResignation;
        this.birthDate = birthDate;
        this.storeOrigin = storeOrigin;
        this.storeCurrent = storeCurrent;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public char getGender() {
        return gender;
    }

    public void setGender(char gender) {
        this.gender = gender;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public LocalDate getDtAdmission() {
        return dtAdmission;
    }

    public void setDtAdmission(LocalDate dtAdmission) {
        this.dtAdmission = dtAdmission;
    }

    public LocalDate getDtResignation() {
        return dtResignation;
    }

    public void setDtResignation(LocalDate dtResignation) {
        if(dtResignation.isBefore(dtAdmission))
            throw new IllegalArgumentException("Data de desligamento não pode ser anterior a data de contratação");
        this.dtResignation = dtResignation;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public Store getStoreOrigin() {
        return storeOrigin;
    }

    public void setStoreOrigin(Store store) {
        this.storeOrigin = store;
    }

    public Store getStoreCurrent() {
        return storeCurrent;
    }

    public void setStoreCurrent(Store storeCurrent) {
        this.storeCurrent = storeCurrent;
    }

//    public Set<License> getLicenses() {
//        return licenses;
//    }

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

    /*public List<Exchange> getGeneratedExchanges() {
        return generatedExchanges;
    }

    public List<Exchange> getReceivedExchanges() {
        return receivedExchanges;
    }*/

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return Objects.equals(id, employee.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
