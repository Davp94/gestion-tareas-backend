package com.blumbit.gestion.gestiontareas.feature.proyecto.command;

import org.springframework.stereotype.Service;

import com.blumbit.gestion.gestiontareas.common.constant.EstadoEnum;
import com.blumbit.gestion.gestiontareas.feature.proyecto.dto.ProyectoRequestDto;
import com.blumbit.gestion.gestiontareas.feature.proyecto.dto.ProyectoResponseDto;
import com.blumbit.gestion.gestiontareas.feature.proyecto.entity.Proyecto;
import com.blumbit.gestion.gestiontareas.feature.proyecto.repository.ProyectoRepository;
import com.blumbit.gestion.gestiontareas.feature.usuario_proyecto_rol.command.CreateUsuarioProyectoRolCommand;
import com.blumbit.gestion.gestiontareas.feature.usuario_proyecto_rol.dto.UsuarioProyectoRolRequestDto;

import jakarta.transaction.Transactional;

@Service
public class CreateProyectoCommand {

    private final ProyectoRepository proyectoRepository;

    private final CreateUsuarioProyectoRolCommand createUsuarioProyectoRolCommand; 

    public CreateProyectoCommand(ProyectoRepository proyectoRepository,
            CreateUsuarioProyectoRolCommand createUsuarioProyectoRolCommand) {
        this.proyectoRepository = proyectoRepository;
        this.createUsuarioProyectoRolCommand = createUsuarioProyectoRolCommand;
    }

    @Transactional
    public ProyectoResponseDto execute(ProyectoRequestDto proyectoRequestDto){
        Proyecto proyectoToCreate = ProyectoRequestDto.buildToEntity(proyectoRequestDto);
        proyectoToCreate.setId((short) (proyectoRepository.count()+1));
        proyectoToCreate.setEstado((short)(EstadoEnum.ACTIVO.getValue()));
        Proyecto proyectoCreated = proyectoRepository.save(proyectoToCreate);
        createUsuarioProyectoRolCommand.execute(UsuarioProyectoRolRequestDto.buildObject(proyectoCreated.getId(), proyectoRequestDto.getUsuarioId(), (short )1));
        return ProyectoResponseDto.buildFromEntity(proyectoCreated);
    }

}
