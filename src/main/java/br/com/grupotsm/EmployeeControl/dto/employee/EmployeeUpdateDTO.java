package br.com.grupotsm.EmployeeControl.dto.employee;

import br.com.grupotsm.EmployeeControl.entities.Employee;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.PastOrPresent;
import java.io.Serializable;
import java.time.LocalDate;

public class EmployeeUpdateDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    @NotBlank(message = "Campo nome não pode ser vazio")
    private String name;
    @NotBlank(message = "Campo email não pode ser vazio")
    @Email(message = "Formato de email incorreto")
    private String email;
    @PastOrPresent(message = "Data de admissão não pode ser futura")
    private LocalDate dtAdmission;
    @PastOrPresent(message = "Data de desligamento não pode ser futura")
    private LocalDate dtResignation;
    @PastOrPresent(message = "Data de nascimento não pode ser futura")
    private LocalDate birthDate;
    private Long idStore;

    public EmployeeUpdateDTO() {
    }

    public EmployeeUpdateDTO(String name, String email, LocalDate dtAdmission, LocalDate dtResignation, LocalDate birthDate, Long idStore) {
        this.name = name;
        this.email = email;
        this.dtAdmission = dtAdmission;
        this.dtResignation = dtResignation;
        this.birthDate = birthDate;
        this.idStore = idStore;
    }

    public EmployeeUpdateDTO(Employee obj) {
        this.name = obj.getName();
        this.email = obj.getEmail();
        this.dtAdmission = obj.getDtAdmission();
        this.dtResignation = obj.getDtResignation();
        this.birthDate = obj.getBirthDate();
        this.idStore = obj.getStore().getId();
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

    public Long getIdStore() {
        return idStore;
    }

    public void setIdStore(Long idStore) {
        this.idStore = idStore;
    }
}
