package br.com.grupotsm.EmployeeControl.entities.enums;

public enum ExpedientType {

    MORNING(1,"Matutino"),
    AFETERNOON(2,"Vespertino"),
    NOCTURNAL(3, "Noturno");

    private int cod;
    private String description;
    ExpedientType(int cod, String description) {
        this.cod = cod;
        this.description = description;
    }

    public int getCod() {
        return cod;
    }

    public String getDescription() {
        return description;
    }

    public static ExpedientType toEnum(Integer cod) {
        if(cod == null) return null;
        for(ExpedientType l: ExpedientType.values())
            if(cod.equals(l.getCod()))
                return l;
        throw new IllegalArgumentException("Opção inválida");
    }
}
