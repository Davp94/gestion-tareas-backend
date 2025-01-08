package com.blumbit.gestion.gestiontareas.feature.proyecto.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
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
