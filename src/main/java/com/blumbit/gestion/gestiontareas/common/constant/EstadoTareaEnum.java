package com.blumbit.gestion.gestiontareas.common.constant;

public enum EstadoTareaEnum {
    BACKLOG(0),
    ASSIGN(1),
    IN_PROGRESS(2),
    COMPLETE(3),
    CLOSE(4);

    private final int valor;

    EstadoTareaEnum(int value) {
        this.valor = value;
    }

    public int getValue() {
        return valor;
    }
}
