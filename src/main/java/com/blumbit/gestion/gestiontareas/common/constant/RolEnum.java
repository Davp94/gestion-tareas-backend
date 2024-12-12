package com.blumbit.gestion.gestiontareas.common.constant;

public enum RolEnum {
    ADMIN(1),
    USER(2);

    private final int valor;

    RolEnum(int value) {
        this.valor = value;
    }

    public int getValue() {
        return valor;
    }
}
