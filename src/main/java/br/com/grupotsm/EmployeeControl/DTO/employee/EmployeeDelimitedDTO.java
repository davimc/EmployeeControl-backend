package br.com.grupotsm.EmployeeControl.DTO.employee;

import br.com.grupotsm.EmployeeControl.entities.Employee;

import java.io.Serializable;
import java.time.LocalDate;

public class EmployeeDelimitedDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private long id;
    private String name;
    private String cpf;


    public EmployeeDelimitedDTO() {
    }

    public EmployeeDelimitedDTO(long id, String name, String cpf) {
        this.id = id;
        this.name = name;
        this.cpf = cpf;
    }
    public EmployeeDelimitedDTO(Employee obj) {
        id = obj.getId();
        name = obj.getName();
        cpf = obj.getCpf();
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

}
