package com.blumbit.gestion.gestiontareas.feature.usuario_proyecto_rol.entity;

import com.blumbit.gestion.gestiontareas.feature.proyecto.entity.Proyecto;
import com.blumbit.gestion.gestiontareas.feature.rol.entity.Rol;
import com.blumbit.gestion.gestiontareas.feature.usuario.entity.Usuario;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "usuario_proyecto_rol", schema = "gestion")
public class UsuarioProyectoRol {
    
    @Id
    @Column(name = "upr_codigo", nullable = false)
    private Short id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "usu_codigo")
    private Usuario usuario;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "rol_codigo")
    private Rol rol;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "pro_codigo")
    private Proyecto proyecto;
}
