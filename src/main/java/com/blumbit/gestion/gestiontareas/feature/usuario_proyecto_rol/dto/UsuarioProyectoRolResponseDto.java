package com.blumbit.gestion.gestiontareas.feature.usuario_proyecto_rol.dto;

import com.blumbit.gestion.gestiontareas.feature.usuario_proyecto_rol.entity.UsuarioProyectoRol;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class UsuarioProyectoRolResponseDto {

    private Short id;

    private Integer usuarioId;

    private Short proyectoId;

    private Short rolId;

    public static UsuarioProyectoRolResponseDto buildFromEntity(UsuarioProyectoRol usuarioProyectoRol){
        return UsuarioProyectoRolResponseDto.builder()
            .id(usuarioProyectoRol.getId())
            .proyectoId(usuarioProyectoRol.getProyecto().getId())
            .rolId(usuarioProyectoRol.getRol().getId())
            .usuarioId(usuarioProyectoRol.getUsuario().getId())
            .build();
    }
}
