package com.blumbit.gestion.gestiontareas.feature.tarea.entity;

import com.blumbit.gestion.gestiontareas.feature.proyecto.entity.Proyecto;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "tarea", schema = "gestion")
public class Tarea {

    @Id
    @Column(name = "tar_codigo", nullable = false)
    private Integer id;

    @Column(name = "tar_titulo")
    private String titulo;

    @Column(name = "tar_descripcion")
    private String descripcion;

    @Column(name = "tar_estado")
    private Short estado;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "pro_codigo")
    private Proyecto proyecto;
}
