package com.blumbit.gestion.gestiontareas.feature.usuario.dto.request;

import com.blumbit.gestion.gestiontareas.feature.usuario.entity.Usuario;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UsuarioRequestDto {

    private String username;

    private String email;

    private String password;

    private String nombres;

    private String apellidos;

     public static Usuario buildToEntity(UsuarioRequestDto usuarioRequestDto){
        return Usuario.builder()
        .nombreCompleto(usuarioRequestDto.getNombres()+"-"+usuarioRequestDto.getApellidos())
        .email(usuarioRequestDto.getEmail())
        .password(usuarioRequestDto.getPassword())
        .username(usuarioRequestDto.getUsername())
        .build();
    }

}
