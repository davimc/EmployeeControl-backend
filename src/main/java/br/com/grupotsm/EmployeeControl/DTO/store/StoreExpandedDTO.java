package br.com.grupotsm.EmployeeControl.DTO.store;

import br.com.grupotsm.EmployeeControl.DTO.employee.EmployeeDelimitedDTO;
import br.com.grupotsm.EmployeeControl.entities.Store;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class StoreExpandedDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long id;
    private String name;
    private String typeName;

    private List<EmployeeDelimitedDTO> employeesBeloging = new ArrayList<>();
    private List<EmployeeDelimitedDTO> employeesCurrent = new ArrayList<>();

    public StoreExpandedDTO() {
    }

    public StoreExpandedDTO(Long id, String name, String typeName, List<EmployeeDelimitedDTO> employeesBeloging, List<EmployeeDelimitedDTO> employeesCurrent) {
        this.id = id;
        this.name = name;
        this.typeName = typeName;
        this.employeesBeloging = employeesBeloging;
        this.employeesCurrent = employeesCurrent;
    }

    public StoreExpandedDTO(Store obj) {
        id = obj.getId();
        name = obj.getName();
        typeName = obj.getType().getName();
        employeesCurrent = obj.getEmployeesCurrent().stream().map(EmployeeDelimitedDTO::new).collect(Collectors.toList());
        employeesBeloging = obj.getEmployeesBeloging().stream().map(EmployeeDelimitedDTO::new).collect(Collectors.toList());
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

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public List<EmployeeDelimitedDTO> getEmployeesBeloging() {
        return employeesBeloging;
    }

    public void setEmployeesBeloging(List<EmployeeDelimitedDTO> employeesBeloging) {
        this.employeesBeloging = employeesBeloging;
    }

    public List<EmployeeDelimitedDTO> getEmployeesCurrent() {
        return employeesCurrent;
    }

    public void setEmployeesCurrent(List<EmployeeDelimitedDTO> employeesCurrent) {
        this.employeesCurrent = employeesCurrent;
    }
}
