package com.blumbit.gestion.gestiontareas.common;

public interface Command<T> {

    T execute() throws Exception;

}
