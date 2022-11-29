package br.com.grupotsm.EmployeeControl.dto.employee;

import br.com.grupotsm.EmployeeControl.entities.Employee;
import br.com.grupotsm.EmployeeControl.entities.Store;
import org.hibernate.validator.constraints.br.CPF;

import javax.validation.constraints.*;
import java.io.Serializable;
import java.time.LocalDate;

public class EmployeeNewDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    @NotBlank(message = "Campo nome não pode ser vazio")
    private String name;
    @NotBlank(message = "Campo email não pode ser vazio")
    @Email(message = "Formato de email incorreto")
    private String email;

    @CPF(message = "Formato de CPF incorreto ou inválido")
    private String cpf;

    @PastOrPresent(message = "Data de admissão não pode ser futura")
    private LocalDate dtAdmission;
    @PastOrPresent(message = "Data de desligamento não pode ser futura")
    private LocalDate dtResignation;

    @Past(message = "Data de aniversário deve ser inferior a atual")
    private LocalDate birthDate;

    @NotNull(message = "O campo loja não pode ser vazio")
    private Long idStore;

    public EmployeeNewDTO() {
    }


    public EmployeeNewDTO(String name, String email, String cpf, LocalDate dtAdmission, LocalDate birthDate, Long idStore) {
        this.name = name;
        this.email = email;
        this.cpf = cpf;
        this.dtAdmission = dtAdmission;
        this.birthDate = birthDate;
        this.idStore = idStore;
    }

    public EmployeeNewDTO(Employee obj) {
        this.name = obj.getName();
        this.email = obj.getEmail();
        this.cpf = obj.getCpf();
        this.dtAdmission = obj.getDtAdmission();
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
