package br.com.grupotsm.EmployeeControl.entities;


import br.com.grupotsm.EmployeeControl.entities.enums.StoreType;

import javax.persistence.*;
import java.io.Serializable;
import java.util.*;

@Entity
@Table(name = "tb_store")
public class Store implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    private int type;

    @OneToMany(mappedBy = "store", fetch = FetchType.EAGER)
    private Set<Employee> employees = new HashSet<>();

    @OneToMany(mappedBy = "generatorStore")
    private List<Exchange> generatedExchanges = new ArrayList<>();
    @OneToMany(mappedBy = "exchangedStore")
    private List<Exchange> receivedExchanges = new ArrayList<>();
    public Store() {
    }

    public Store(Long id, String name, StoreType storeType) {
        this.id = id;
        this.name = name;
        this.type = storeType.getCod();
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

    public StoreType getType() {
        return StoreType.toEnum(type);
    }

    public void setType(StoreType type) {
        this.type = type.getCod();
    }

    public Set<Employee> getEmployees() {
        return employees;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Store obj = (Store) o;
        return id.equals(obj.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
