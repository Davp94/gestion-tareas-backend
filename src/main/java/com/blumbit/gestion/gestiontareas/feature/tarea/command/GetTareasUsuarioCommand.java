package com.blumbit.gestion.gestiontareas.feature.tarea.command;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.blumbit.gestion.gestiontareas.feature.tarea.dto.TareaRequestDto;
import com.blumbit.gestion.gestiontareas.feature.tarea.dto.TareaResponseDto;
import com.blumbit.gestion.gestiontareas.feature.tarea.entity.Tarea;
import com.blumbit.gestion.gestiontareas.feature.tarea.repository.TareaRepository;

@Service
public class GetTareasUsuarioCommand {

     private final TareaRepository tareaRepository;

    public GetTareasUsuarioCommand(TareaRepository tareaRepository) {
        this.tareaRepository = tareaRepository;
    }

    List<TareaResponseDto> execute(TareaRequestDto tareaRequestDto){
        List<Tarea> tareasRetrieved = tareaRepository.findByProyecto_IdAndUsuario_Id(tareaRequestDto.getProyectoId(), tareaRequestDto.getUsuarioId());
        return tareasRetrieved.stream().map(TareaResponseDto::buildFromEntity).collect(Collectors.toList());
    }



}
