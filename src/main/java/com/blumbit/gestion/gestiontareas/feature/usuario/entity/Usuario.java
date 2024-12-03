package com.blumbit.gestion.gestiontareas.feature.usuario.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Usuarios", schema = "gestion")
public class Usuario {

    @Id
    Integer usuCodigo; //usu_codigo

}
