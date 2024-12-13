package com.blumbit.gestion.gestiontareas.feature.proyecto.dto;

import com.blumbit.gestion.gestiontareas.feature.usuario_proyecto_rol.entity.UsuarioProyectoRol;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class FindProyectoResponseDto {

    private Short id;

    private String nombre;

    private String descripcion;

    private String rolName;

    public static FindProyectoResponseDto buildObject(UsuarioProyectoRol usuarioProyectoRol){
        return FindProyectoResponseDto.builder()
                .id(usuarioProyectoRol.getProyecto().getId())
                .nombre(usuarioProyectoRol.getProyecto().getNombre())
                .descripcion(usuarioProyectoRol.getProyecto().getDescripcion())
                .rolName(usuarioProyectoRol.getRol().getNombre())
                .build();
        
    }

}
