package com.blumbit.gestion.gestiontareas.feature.tarea.dto;

import com.blumbit.gestion.gestiontareas.feature.tarea.entity.Tarea;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class TareaRequestDto {

    private Integer usuarioId;

    private Short proyectoId;

    private String titulo;

    private String descripcion;

    public static Tarea buildToEntity(TareaRequestDto tareaRequestDto){
        return Tarea.builder()
                .descripcion(tareaRequestDto.getDescripcion())
                .titulo(tareaRequestDto.getTitulo())
                .build();
    }
}
