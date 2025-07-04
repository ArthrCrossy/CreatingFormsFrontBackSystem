package gestaoRh.demo.model;

public enum Departamento {
    TI("TI"),
    RH("RH"),
    FINANCEIRO("Financeiro"),
    MARKETING("Marketing"),
    OPERACOES("Operações");

    private final String valor;

    Departamento(String valor) {
        this.valor = valor;
    }

    public String getValor() {
        return valor;
    }
}
