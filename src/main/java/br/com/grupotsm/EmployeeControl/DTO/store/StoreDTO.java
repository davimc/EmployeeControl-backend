package br.com.grupotsm.EmployeeControl.DTO.store;

import br.com.grupotsm.EmployeeControl.entities.Store;

import java.io.Serializable;

public class StoreDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long id;
    private String name;
    private String typeName;

    public StoreDTO() {
    }

    public StoreDTO(Long id, String name, String typeName) {
        this.id = id;
        this.name = name;
        this.typeName = typeName;
    }
    public StoreDTO(Store obj) {
        this.id = obj.getId();
        this.name = obj.getName();
        this.typeName = obj.getType().getName();
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
}
