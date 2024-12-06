package com.blumbit.gestion.gestiontareas.feature.usuario.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "usuario", schema = "gestion")
public class Usuario {

    @Id
    @Column(name = "usu_codigo", nullable = false)
    private Integer id;

    @Column(name = "usu_username", length = 100)
    private String username;

    @Column(name = "usu_email", length = 150)
    private String email;

    @Column(name = "usu_password")
    private String password;

    @Column(name = "usu_nombre_completo")
    private String nombreCompleto;

    @Column(name = "usu_avatar")
    private String avatar;

    @Column(name = "usu_estado")
    private Short estado;
    
}
