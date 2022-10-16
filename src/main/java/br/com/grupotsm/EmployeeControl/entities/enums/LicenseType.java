package br.com.grupotsm.EmployeeControl.entities.enums;

public enum LicenseType {

    ABSCENSE(1, "Ausência"),
    CERTIFICATE (2, "Atestado"),
    PATERNITY(5, "Paternidade"),
    VACATION (30, "Férias"),
    MATERNITY (120, "Maternidade");

    private int periodSuggestion;
    private String description;
    LicenseType(int periodSuggestion, String description) {
        this.periodSuggestion = periodSuggestion;
        this.description = description;
    }

    public int getPeriodSuggestion() {
        return periodSuggestion;
    }

    public void setPeriodSuggestion(int periodSuggestion) {
        this.periodSuggestion = periodSuggestion;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public static LicenseType toEnum(Integer cod) {
        if(cod == null) return null;
        for(LicenseType l: LicenseType.values())
            if(cod.equals(l.getPeriodSuggestion()))
                return l;
        throw new IllegalArgumentException("Licença inválida");
    }
}
