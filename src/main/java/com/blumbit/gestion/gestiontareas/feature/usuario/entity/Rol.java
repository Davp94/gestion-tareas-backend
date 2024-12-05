package com.blumbit.gestion.gestiontareas.feature.usuario.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "rol", schema = "gestion")
public class Rol {

    @Id
    @Column(name = "rol_codigo", nullable = false)
    private Short id;

    @Column(name = "rol_nombre")
    private String nombre;

    @Column(name = "rol_descripcion")
    private String descripcion;

}
