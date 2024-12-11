package com.blumbit.gestion.gestiontareas.feature.usuario.command;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.blumbit.gestion.gestiontareas.common.constant.EstadoEnum;
import com.blumbit.gestion.gestiontareas.feature.usuario.dto.request.UsuarioRequestDto;
import com.blumbit.gestion.gestiontareas.feature.usuario.dto.response.UsuarioResponseDto;
import com.blumbit.gestion.gestiontareas.feature.usuario.entity.Usuario;
import com.blumbit.gestion.gestiontareas.feature.usuario.repository.UsuarioRepository;

@Service
public class CreateUsuarioCommand {

    private final UsuarioRepository usuarioRepository;

    private final PasswordEncoder passwordEncoder;

    public CreateUsuarioCommand(UsuarioRepository usuarioRepository, PasswordEncoder passwordEncoder) {
        this.usuarioRepository = usuarioRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public UsuarioResponseDto execute(UsuarioRequestDto usuarioRequestDto) {
        try {
            //TODO add avatar from image implemention
            Usuario usuarioToCreated = UsuarioRequestDto.buildToEntity(usuarioRequestDto);
            usuarioToCreated.setAvatar(null);
            usuarioToCreated.setEstado((short)(EstadoEnum.ACTIVO.getValue()));
            usuarioToCreated.setPassword(passwordEncoder.encode(usuarioToCreated.getPassword()));
            usuarioToCreated.setId((int) (usuarioRepository.count()+1));
            return UsuarioResponseDto.buildFromEntity(usuarioRepository.save(usuarioToCreated));
        } catch (Exception e) {
            throw new RuntimeException("Error al crear el usuario");
        }
    }
}
