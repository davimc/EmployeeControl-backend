package br.com.grupotsm.EmployeeControl.dto.store;

import br.com.grupotsm.EmployeeControl.dto.employee.EmployeeDTO;
import br.com.grupotsm.EmployeeControl.entities.Store;

import javax.validation.constraints.NotBlank;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class StoreWithEmployeeDTO extends StoreDTO{
    private List<EmployeeDTO> employees = new ArrayList<>();

    public StoreWithEmployeeDTO() {
    }

    public StoreWithEmployeeDTO(Long id, String name, List<EmployeeDTO> employees) {
        super(id, name);
        this.employees = employees;
    }

    public StoreWithEmployeeDTO(Store entity) {
        super(entity);
        this.employees = entity.getEmployees().stream().map(EmployeeDTO::new).collect(Collectors.toList());
    }

    public List<EmployeeDTO> getEmployees() {
        return employees;
    }

    public void setEmployees(List<EmployeeDTO> employees) {
        this.employees = employees;
    }
}
