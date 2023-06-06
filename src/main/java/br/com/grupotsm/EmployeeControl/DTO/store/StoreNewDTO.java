package br.com.grupotsm.EmployeeControl.DTO.store;

import br.com.grupotsm.EmployeeControl.entities.Store;
import br.com.grupotsm.EmployeeControl.entities.enums.StoreType;
import org.springframework.beans.factory.annotation.Value;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;
import java.io.Serializable;

public class StoreNewDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    @NotNull(message = "It is necessary to inform a name")
    @Size(message = "Required size min 3, max 25", min = 3, max = 25)
    private String name;

    @NotNull(message = "It is necessary to inform a name")
    @Positive(message = "This field need to be positive")
    private Integer type;

    public StoreNewDTO() {
    }

    public StoreNewDTO(Long id, String name, Integer type) {
        this.name = name;
        this.type = type;

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Store toModel() {
        return new Store(null, getName(), StoreType.toEnum(type));
    }
}
