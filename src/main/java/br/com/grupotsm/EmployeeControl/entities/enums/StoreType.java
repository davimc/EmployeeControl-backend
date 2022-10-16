package br.com.grupotsm.EmployeeControl.entities.enums;

public enum StoreType {

    SUBWAY(1),
    COFFEE_SHOP(2),
    RESTAURANT(3);

    private int cod;
    StoreType(int cod) {
        this.cod = cod;
    }

    public int getCod() {
        return cod;
    }

    public void setCod(int cod) {
        this.cod = cod;
    }

    public static StoreType toEnum(Integer cod) {
        if(cod == null) return null;
        for(StoreType s: StoreType.values())
            if(cod.equals(s.getCod()))
                return s;
        throw new IllegalArgumentException("Tipo de Loja inválida");
    }
}
