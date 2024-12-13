package com.blumbit.gestion.gestiontareas.feature.tarea.dto;

import com.blumbit.gestion.gestiontareas.common.constant.EstadoTareaEnum;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ChangeStateTareaDto {

    private Integer tareaId;

    private EstadoTareaEnum estadoTarea;

}
