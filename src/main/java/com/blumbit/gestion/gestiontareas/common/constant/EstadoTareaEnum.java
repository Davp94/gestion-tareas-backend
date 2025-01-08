package com.blumbit.gestion.gestiontareas.common.constant;

public enum EstadoTareaEnum {
    TO_DO(1),
    IN_PROGRESS(2),
    DONE(3);

    private final int valor;

    EstadoTareaEnum(int value) {
        this.valor = value;
    }

    public int getValue() {
        return valor;
    }
}
