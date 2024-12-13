package com.blumbit.gestion.gestiontareas.feature.tarea.command;

import org.springframework.stereotype.Service;

import com.blumbit.gestion.gestiontareas.feature.tarea.dto.ChangeStateTareaDto;
import com.blumbit.gestion.gestiontareas.feature.tarea.dto.TareaResponseDto;
import com.blumbit.gestion.gestiontareas.feature.tarea.entity.Tarea;
import com.blumbit.gestion.gestiontareas.feature.tarea.repository.TareaRepository;

@Service
public class ChangeStateTareaCommand {

    private final TareaRepository tareaRepository;

    public ChangeStateTareaCommand(TareaRepository tareaRepository) {
        this.tareaRepository = tareaRepository;
    }

    public TareaResponseDto execute(ChangeStateTareaDto changeStateTareaDto){
        Tarea tareaRetrieved = tareaRepository.findById(changeStateTareaDto.getTareaId()).get();
        tareaRetrieved.setEstado((short) changeStateTareaDto.getEstadoTarea().getValue());
        Tarea tareaUpdated = tareaRepository.save(tareaRetrieved);
        return(TareaResponseDto.buildFromEntity(tareaUpdated));
    }

}
