package com.blumbit.gestion.gestiontareas.feature.proyecto.dto;

import com.blumbit.gestion.gestiontareas.feature.proyecto.entity.Proyecto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class ProyectoRequestDto {

    private String nombre;

    private String descripcion;

    private Integer usuarioId;

    public static Proyecto buildToEntity(ProyectoRequestDto proyectoRequestDto) {
        return Proyecto.builder()
                .descripcion(proyectoRequestDto.getDescripcion())
                .nombre(proyectoRequestDto.getNombre())
                .build();
    }
}
