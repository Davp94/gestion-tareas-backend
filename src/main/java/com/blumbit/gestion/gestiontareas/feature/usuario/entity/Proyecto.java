package com.blumbit.gestion.gestiontareas.feature.usuario.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "proyecto", schema = "gestion")
public class Proyecto {

    @Id
    @Column(name = "pro_codigo", nullable = false)
    private Short id;

    @Column(name = "pro_nombre")
    private String nombre;

    @Column(name = "pro_descripcion")
    private String descripcion;

    @Column(name = "pro_estado")
    private Short estado;

}
