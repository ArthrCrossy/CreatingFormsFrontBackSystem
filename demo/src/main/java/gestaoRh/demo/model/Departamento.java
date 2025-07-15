package gestaoRh.demo.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum Departamento {
    FINANCEIRO("Financeiro"),
    TI("TI"),
    RH("RH"),
    OPERACOES("Operações"),
    MARKETING("Marketing");

    private final String displayName;

    Departamento(String displayName) {
        this.displayName = displayName;
    }

    @JsonValue
    public String getDisplayName() {
        return displayName;
    }

    @JsonCreator
    public static Departamento fromString(String value) {
        if (value == null || value.trim().isEmpty()) {
            return null;
        }

        String normalizedValue = value.trim();

        // Tenta encontrar por display name
        for (Departamento dept : Departamento.values()) {
            if (dept.displayName.equalsIgnoreCase(normalizedValue)) {
                return dept;
            }
        }

        // Tenta encontrar por nome do enum
        for (Departamento dept : Departamento.values()) {
            if (dept.name().equalsIgnoreCase(normalizedValue)) {
                return dept;
            }
        }

        throw new IllegalArgumentException("Valor inválido para Departamento: " + value);
    }
}