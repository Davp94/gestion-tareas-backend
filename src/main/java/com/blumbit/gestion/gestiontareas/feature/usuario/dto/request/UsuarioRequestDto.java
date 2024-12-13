package com.blumbit.gestion.gestiontareas.feature.usuario.dto.request;

import com.blumbit.gestion.gestiontareas.feature.usuario.entity.Usuario;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UsuarioRequestDto {

    @NotNull()
    @NotBlank()
    private String username;

    @Email
    private String email;

    @Pattern(regexp = "")
    private String password;

    @NotNull()
    @NotBlank()
    private String nombres;

    @NotNull()
    @NotBlank()
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
