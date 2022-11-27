package br.com.grupotsm.EmployeeControl.dto.store;

import br.com.grupotsm.EmployeeControl.dto.employee.EmployeeDTO;
import br.com.grupotsm.EmployeeControl.entities.Store;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class StoreDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private long id;
    private String name;
    private List<EmployeeDTO> employees = new ArrayList<>();

    public StoreDTO() {
    }

    public StoreDTO(Long id, String name, List<EmployeeDTO> employees) {
        this.id = id;
        this.name = name;
        this.employees = employees;
    }

    public StoreDTO(Store entity) {
        this.id = entity.getId();
        this.name = entity.getName();
        this.employees = entity.getEmployees().stream().map(EmployeeDTO::new).collect(Collectors.toList());
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

    public List<EmployeeDTO> getEmployees() {
        return employees;
    }

    public void setEmployees(List<EmployeeDTO> employees) {
        this.employees = employees;
    }
}
