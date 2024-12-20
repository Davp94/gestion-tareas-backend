package com.blumbit.gestion.gestiontareas.feature.usuario.command;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.blumbit.gestion.gestiontareas.common.command.FileManagerCommand;
import com.blumbit.gestion.gestiontareas.common.constant.EstadoEnum;
import com.blumbit.gestion.gestiontareas.feature.usuario.dto.request.UsuarioRequestDto;
import com.blumbit.gestion.gestiontareas.feature.usuario.dto.response.UsuarioResponseDto;
import com.blumbit.gestion.gestiontareas.feature.usuario.entity.Usuario;
import com.blumbit.gestion.gestiontareas.feature.usuario.repository.UsuarioRepository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class CreateUsuarioCommand {

    private final UsuarioRepository usuarioRepository;

    private final PasswordEncoder passwordEncoder;

    private final FileManagerCommand fileManagerCommand;

    public CreateUsuarioCommand(UsuarioRepository usuarioRepository, PasswordEncoder passwordEncoder,
            FileManagerCommand fileManagerCommand) {
        this.usuarioRepository = usuarioRepository;
        this.passwordEncoder = passwordEncoder;
        this.fileManagerCommand = fileManagerCommand;
    }



    public UsuarioResponseDto execute(UsuarioRequestDto usuarioRequestDto) {
        try {
            Usuario usuarioToCreated = UsuarioRequestDto.buildToEntity(usuarioRequestDto);
            usuarioToCreated.setAvatar(fileManagerCommand.execute(usuarioRequestDto.getAvatar()));
            usuarioToCreated.setEstado((short)(EstadoEnum.ACTIVO.getValue()));
            usuarioToCreated.setPassword(passwordEncoder.encode(usuarioToCreated.getPassword()));
            usuarioToCreated.setId((int) (usuarioRepository.count()+1));
            return UsuarioResponseDto.buildFromEntity(usuarioRepository.save(usuarioToCreated));
        } catch (RuntimeException e) {
            log.error(e.getMessage(), e);
            throw new RuntimeException("Error al crear el usuario");
        } 
    }
}
