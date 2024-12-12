package com.blumbit.gestion.gestiontareas.feature.usuario_proyecto_rol.command;


import org.springframework.stereotype.Service;

import com.blumbit.gestion.gestiontareas.feature.proyecto.entity.Proyecto;
import com.blumbit.gestion.gestiontareas.feature.rol.entity.Rol;
import com.blumbit.gestion.gestiontareas.feature.usuario.entity.Usuario;
import com.blumbit.gestion.gestiontareas.feature.usuario_proyecto_rol.dto.UsuarioProyectoRolRequestDto;
import com.blumbit.gestion.gestiontareas.feature.usuario_proyecto_rol.dto.UsuarioProyectoRolResponseDto;
import com.blumbit.gestion.gestiontareas.feature.usuario_proyecto_rol.entity.UsuarioProyectoRol;
import com.blumbit.gestion.gestiontareas.feature.usuario_proyecto_rol.repository.UsuarioProyectoRolRepository;

import jakarta.persistence.EntityManager;

@Service
public class CreateUsuarioProyectoRolCommand {

    private UsuarioProyectoRolRepository usuarioProyectoRolRepository;

    private EntityManager entityManager;

    public CreateUsuarioProyectoRolCommand(UsuarioProyectoRolRepository usuarioProyectoRolRepository) {
        this.usuarioProyectoRolRepository = usuarioProyectoRolRepository;
    }

    public UsuarioProyectoRolResponseDto execute(UsuarioProyectoRolRequestDto usuarioProyectoRolRequestDto){
        UsuarioProyectoRol usuarioProyectoRol = new UsuarioProyectoRol();
        usuarioProyectoRol.setId((short) (usuarioProyectoRolRepository.count()+1));
        usuarioProyectoRol.setProyecto(entityManager.getReference(Proyecto.class, usuarioProyectoRolRequestDto.getProyectoId()));
        usuarioProyectoRol.setRol(entityManager.getReference(Rol.class, usuarioProyectoRolRequestDto.getRolId()));
        usuarioProyectoRol.setUsuario(entityManager.getReference(Usuario.class, usuarioProyectoRolRequestDto.getUsuarioid()));
        UsuarioProyectoRol usuarioProyectoRolCreated = usuarioProyectoRolRepository.save(usuarioProyectoRol);
        return UsuarioProyectoRolResponseDto.buildFromEntity(usuarioProyectoRolCreated);

    } 

    
}
