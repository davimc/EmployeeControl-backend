package br.com.grupotsm.EmployeeControl.entities.enums;

public enum ExchangeState {

    PENDING(1,"Pendente"),
    APPROVED(1,"Aprovado"),
    ACTIVE(2, "Ativo"),
    CONCLUDED(3, "Concluído"),
    CANCELED(4, "Cancelado");

    private int cod;
    private String name;
    ExchangeState(int cod, String name) {
        this.cod = cod;
        this.name = name;
    }

    public int getCod() {
        return cod;
    }

    public void setCod(int cod) {
        this.cod = cod;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static ExchangeState toEnum(Integer cod) {
        if(cod == null) return null;
        for(ExchangeState s: ExchangeState.values())
            if(cod.equals(s.getCod()))
                return s;
        throw new IllegalArgumentException("Estado inválido");
    }
}
