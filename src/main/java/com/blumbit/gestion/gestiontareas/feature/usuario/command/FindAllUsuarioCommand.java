package com.blumbit.gestion.gestiontareas.feature.usuario.command;

import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;
import com.blumbit.gestion.gestiontareas.common.Command;
import com.blumbit.gestion.gestiontareas.feature.usuario.dto.response.UsuarioResponseDto;
import com.blumbit.gestion.gestiontareas.feature.usuario.entity.Usuario;
import com.blumbit.gestion.gestiontareas.feature.usuario.repository.UsuarioRepository;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class FindAllUsuarioCommand implements Command<List<UsuarioResponseDto>>{

    private final UsuarioRepository usuarioRepository;

    public FindAllUsuarioCommand(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }
    @Override
    public List<UsuarioResponseDto> execute() {
        log.debug("DEBUGGING LIST USUARIOS COMMAND");
        try {
            List<Usuario> usuario = usuarioRepository.findAll();
            log.debug("usuarioData",usuario);
            System.out.println(usuario);
            List<UsuarioResponseDto> usuarioResponseDtos = usuario.stream().map(UsuarioResponseDto::buildFromEntity).collect(Collectors.toList());
            System.out.println(usuarioResponseDtos);
            return usuarioResponseDtos; 
        } catch (Exception e) {
            log.debug(e.getMessage(), e);
           throw new RuntimeException(e.getMessage());
        }
        
    }

}
