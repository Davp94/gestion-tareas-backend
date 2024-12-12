package com.blumbit.gestion.gestiontareas.feature.proyecto.dto;

import com.blumbit.gestion.gestiontareas.feature.proyecto.entity.Proyecto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class ProyectoResponseDto {

    private Short id;

    private String nombre;

    private String descripcion;

    public static ProyectoResponseDto buildFromEntity(Proyecto proyecto){
        return ProyectoResponseDto.builder()
                .id(proyecto.getId())
                .descripcion(proyecto.getDescripcion())
                .nombre(proyecto.getNombre())
                .build();
    }

}
