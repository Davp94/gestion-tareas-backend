package com.blumbit.gestion.gestiontareas.feature.usuario_proyecto_rol.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class UsuarioProyectoRolRequestDto {

    private Short proyectoId;

    private Integer usuarioid;

    private Short rolId;

    public static UsuarioProyectoRolRequestDto buildObject(Short proyectoId, Integer usuarioId, Short rolId){
        return UsuarioProyectoRolRequestDto.builder()
                .proyectoId(proyectoId)
                .rolId(rolId)
                .usuarioid(usuarioId)
                .build();
    }

}
