package com.blumbit.gestion.gestiontareas.common.constant;

public enum EstadoEnum {
    INACTIVO(0),
    ACTIVO(1);

    private final int valor;

    EstadoEnum(int value) {
        this.valor = value;
    }

    public int getValue() {
        return valor;
    }
}
