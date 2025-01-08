package com.blumbit.gestion.gestiontareas.feature.proyecto.command;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.blumbit.gestion.gestiontareas.feature.proyecto.dto.FindProyectoRequestDto;
import com.blumbit.gestion.gestiontareas.feature.proyecto.dto.FindProyectoResponseDto;
import com.blumbit.gestion.gestiontareas.feature.usuario_proyecto_rol.entity.UsuarioProyectoRol;
import com.blumbit.gestion.gestiontareas.feature.usuario_proyecto_rol.repository.UsuarioProyectoRolRepository;

@Service
public class FindProyectosUsuarioCommand {

    private final UsuarioProyectoRolRepository usuarioProyectoRolRepository;

    public FindProyectosUsuarioCommand(UsuarioProyectoRolRepository usuarioProyectoRolRepository) {
        this.usuarioProyectoRolRepository = usuarioProyectoRolRepository;
    }

    public List<FindProyectoResponseDto> execute(Integer usuarioId){

        List<UsuarioProyectoRol> usuarioProyectoRolRetrieved = usuarioProyectoRolRepository.findByUsuario_id(usuarioId);
        return usuarioProyectoRolRetrieved.stream().map(FindProyectoResponseDto::buildObject).collect(Collectors.toList());
    }
    
}
