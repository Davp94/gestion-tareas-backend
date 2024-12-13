package com.blumbit.gestion.gestiontareas.feature.tarea.dto;

import com.blumbit.gestion.gestiontareas.feature.tarea.entity.Tarea;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class TareaResponseDto {

    private Integer id;

    private String titulo;

    private String descripcion;

    private Short estado; 

    public static TareaResponseDto buildFromEntity(Tarea tarea){
        return TareaResponseDto.builder()
                .id(tarea.getId())
                .descripcion(tarea.getDescripcion())
                .titulo(tarea.getTitulo())
                .estado(tarea.getEstado())
                .build();

    }
}
