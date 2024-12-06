package com.blumbit.gestion.gestiontareas.feature.usuario.dto.response;

import com.blumbit.gestion.gestiontareas.feature.usuario.entity.Usuario;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UsuarioResponseDto {

    private Integer id;

    private String username;

    private String email;

    private String nombres;

    private String apellidos;

    private String avatar;

    private Short estado;

    public static UsuarioResponseDto buildFromEntity(Usuario usuario){
        return UsuarioResponseDto.builder()
        .id(usuario.getId())
        .nombres(usuario.getNombreCompleto().split("-")[0])
        .apellidos(usuario.getNombreCompleto().split("-")[1])
        .avatar(usuario.getAvatar())
        .email(usuario.getEmail())
        .username(usuario.getUsername())
        .estado(usuario.getEstado())
        .build();
    }

}
