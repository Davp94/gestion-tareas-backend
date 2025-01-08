package com.blumbit.gestion.gestiontareas.feature.tarea.dto;

import com.blumbit.gestion.gestiontareas.feature.tarea.entity.Tarea;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
@JsonIgnoreProperties(ignoreUnknown = true)
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
