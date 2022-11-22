package br.com.grupotsm.EmployeeControl.test;

import br.com.grupotsm.EmployeeControl.dto.employee.EmployeeDTO;
import br.com.grupotsm.EmployeeControl.dto.store.StoreDTO;
import br.com.grupotsm.EmployeeControl.entities.Employee;
import br.com.grupotsm.EmployeeControl.entities.License;
import br.com.grupotsm.EmployeeControl.entities.Shift;
import br.com.grupotsm.EmployeeControl.entities.Store;
import br.com.grupotsm.EmployeeControl.entities.enums.ReasonType;
import br.com.grupotsm.EmployeeControl.entities.enums.StoreType;

import java.time.Instant;
import java.time.LocalDate;

public class Factory {

    public static Employee createEmployee() {
        Employee obj =  new Employee(1L, "Davi", 'M', "davimatosc@hotmail.com", "607.272.893-65", LocalDate.now(), LocalDate.of(1995,06,02), new Store());
        return obj;
    }

    public static EmployeeDTO createEmployeeDTO() {
        Employee obj = createEmployee();
        EmployeeDTO dto = new EmployeeDTO(obj);
        dto.setId(1L);

        return dto;
    }
    public static License createLicense() {
        License obj =  new License(1L, LocalDate.now(), LocalDate.now().plusDays(2), ReasonType.CERTIFICATE, "Conjuntivite", new Employee());
        return obj;
    }

    public static EmployeeDTO createLicenseDTO() {
        Employee obj = createEmployee();
        EmployeeDTO dto = new EmployeeDTO(obj);
        dto.setId(1L);

        return dto;
    }
    public static Store createStore() {
        Store obj =  new Store(1L, "Narnia", StoreType.SUBWAY);
        return obj;
    }

    public static StoreDTO createStoreDTO() {
        Store obj = createStore();
        StoreDTO dto = new StoreDTO(obj);
        dto.setId(1L);

        return dto;
    }
    public static Shift createShift() {
        Shift obj =  new Shift(1L, LocalDate.now(),LocalDate.now().plusDays(5),new Store(), new Employee(), new Employee(), new License());
        return obj;
    }

}