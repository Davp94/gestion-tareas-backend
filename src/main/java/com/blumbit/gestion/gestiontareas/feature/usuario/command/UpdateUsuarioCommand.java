package com.blumbit.gestion.gestiontareas.feature.usuario.command;

import org.springframework.stereotype.Component;

import com.blumbit.gestion.gestiontareas.feature.usuario.dto.request.UsuarioRequestDto;
import com.blumbit.gestion.gestiontareas.feature.usuario.dto.response.UsuarioResponseDto;
import com.blumbit.gestion.gestiontareas.feature.usuario.entity.Usuario;
import com.blumbit.gestion.gestiontareas.feature.usuario.repository.UsuarioRepository;

@Component
public class UpdateUsuarioCommand {

    private final UsuarioRepository usuarioRepository;

    public UpdateUsuarioCommand(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    public UsuarioResponseDto execute(UsuarioRequestDto usuarioRequestDto, Integer id) {

        Usuario usuarioToUpdate = updateData(usuarioRepository.findById(id).get(), UsuarioRequestDto.buildToEntity(usuarioRequestDto));
        return UsuarioResponseDto.buildFromEntity(usuarioRepository.save(usuarioToUpdate));
    }

    private Usuario updateData(Usuario usuarioToUpdate, Usuario usuarioNewData){
        usuarioToUpdate.setPassword(usuarioNewData.getPassword());
        usuarioToUpdate.setEmail(usuarioNewData.getEmail());
        usuarioToUpdate.setUsername(usuarioNewData.getUsername());
        usuarioToUpdate.setNombreCompleto(usuarioNewData.getNombreCompleto());
        return usuarioToUpdate;
    }

}
