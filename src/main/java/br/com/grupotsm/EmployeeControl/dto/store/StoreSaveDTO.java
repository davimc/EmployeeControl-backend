package br.com.grupotsm.EmployeeControl.dto.store;

import br.com.grupotsm.EmployeeControl.entities.Store;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;

public class StoreSaveDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    private Long id;
    @NotBlank(message = "O campo nome não pode ficar vazio")
    private String name;

    public StoreSaveDTO() {
    }

    public StoreSaveDTO(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public StoreSaveDTO(Store entity) {
        this.id = entity.getId();
        this.name = entity.getName();
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
}
