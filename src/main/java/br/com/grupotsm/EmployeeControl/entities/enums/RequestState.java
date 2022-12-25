package br.com.grupotsm.EmployeeControl.entities.enums;

public enum RequestState {

    PENDING(1,"Pendente"),
    ACCEPT(2,"Aceito"),
    REFUSED(3, "Recusado"),
    WAITING(4, "Aguardando resposta"),
    CANCELED(4, "Cancelado");

    private int cod;
    private String description;
    RequestState(int cod, String description) {
        this.cod = cod;
        this.description = description;
    }

    public int getCod() {
        return cod;
    }

    public String getDescription() {
        return description;
    }

    public static RequestState toEnum(Integer cod) {
        if(cod == null) return null;
        for(RequestState l: RequestState.values())
            if(cod.equals(l.getCod()))
                return l;
        throw new IllegalArgumentException("Opção inválida");
    }
}
