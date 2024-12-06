package com.blumbit.gestion.gestiontareas.feature.usuario.command;

import java.util.List;

import org.springframework.stereotype.Component;
import com.blumbit.gestion.gestiontareas.common.Command;
import com.blumbit.gestion.gestiontareas.feature.usuario.dto.response.UsuarioResponseDto;
import com.blumbit.gestion.gestiontareas.feature.usuario.repository.UsuarioRepository;

@Component
public class FindAllUsuarioCommand implements Command<List<UsuarioResponseDto>>{

    private final UsuarioRepository usuarioRepository;

    public FindAllUsuarioCommand(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }
    @Override
    public List<UsuarioResponseDto> execute() {
        return usuarioRepository.findAll().stream().map(res->UsuarioResponseDto.buildFromEntity(res)).toList();
    }

}
