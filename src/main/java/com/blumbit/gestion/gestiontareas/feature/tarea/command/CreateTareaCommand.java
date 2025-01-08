package com.blumbit.gestion.gestiontareas.feature.tarea.command;

import org.springframework.stereotype.Service;

import com.blumbit.gestion.gestiontareas.common.constant.EstadoTareaEnum;
import com.blumbit.gestion.gestiontareas.feature.proyecto.entity.Proyecto;
import com.blumbit.gestion.gestiontareas.feature.tarea.dto.TareaRequestDto;
import com.blumbit.gestion.gestiontareas.feature.tarea.dto.TareaResponseDto;
import com.blumbit.gestion.gestiontareas.feature.tarea.entity.Tarea;
import com.blumbit.gestion.gestiontareas.feature.tarea.repository.TareaRepository;
import com.blumbit.gestion.gestiontareas.feature.usuario.entity.Usuario;

import jakarta.persistence.EntityManager;

@Service
public class CreateTareaCommand {

    private final TareaRepository tareaRepository;

    private final EntityManager entityManager;

    public CreateTareaCommand(TareaRepository tareaRepository, EntityManager entityManager) {
        this.tareaRepository = tareaRepository;
        this.entityManager = entityManager;
    }

    public TareaResponseDto execute(TareaRequestDto tareaRequestDto){
        if(!validateOperation(tareaRequestDto.getProyectoId(), tareaRequestDto.getUsuarioId())){
            throw new RuntimeException("El usuario no pertenece al proyecto seleccionado");
        }
        Tarea tareaToCreate = TareaRequestDto.buildToEntity(tareaRequestDto);
        tareaToCreate.setId((int)(tareaRepository.count()+1));
        tareaToCreate.setEstado((short) EstadoTareaEnum.TO_DO.getValue());
        tareaToCreate.setProyecto(entityManager.getReference(Proyecto.class, tareaRequestDto.getProyectoId()));
        tareaToCreate.setUsuario(entityManager.getReference(Usuario.class, tareaRequestDto.getUsuarioId()));

        Tarea tareaCreated = tareaRepository.save(tareaToCreate);
        return TareaResponseDto.buildFromEntity(tareaCreated);
    }

    boolean validateOperation(Short proyectoId, Integer usuarioId){
        return true;
    }

}
