package br.com.grupotsm.EmployeeControl.dto.employee;

import br.com.grupotsm.EmployeeControl.entities.Employee;
import br.com.grupotsm.EmployeeControl.entities.Store;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.hibernate.validator.constraints.br.CPF;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Past;
import javax.validation.constraints.PastOrPresent;
import java.time.LocalDate;

public class EmployeeDTO {
    private Long id;
    private String name;
    private String email;
    private String cpf;
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate dtAdmission;
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate dtResignation;
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate birthDate;
    private String nameStore;

    public EmployeeDTO() {
    }

    public EmployeeDTO(Long id, String name, String email, String cpf, LocalDate dtAdmission, LocalDate dtResignation, LocalDate birthDate, String nameStore) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.cpf = cpf;
        this.dtAdmission = dtAdmission;
        this.dtResignation = dtResignation;
        this.birthDate = birthDate;
        this.nameStore = nameStore;
    }

    public EmployeeDTO(Employee obj) {
        this.id = obj.getId();
        this.name = obj.getName();
        this.email = obj.getEmail();
        this.cpf = obj.getCpf();
        this.dtAdmission = obj.getDtAdmission();
        this.dtResignation = obj.getDtResignation();
        this.birthDate = obj.getBirthDate();
        this.nameStore = obj.getStore().getName();
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
        this.dtResignation = dtResignation;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public String getNameStore() {
        return nameStore;
    }

    public void setNameStore(String nameStore) {
        this.nameStore = nameStore;
    }
}
