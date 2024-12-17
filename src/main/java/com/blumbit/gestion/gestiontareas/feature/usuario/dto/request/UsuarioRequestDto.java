package com.blumbit.gestion.gestiontareas.feature.usuario.dto.request;

import org.springframework.web.multipart.MultipartFile;

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

    @NotNull(message = "el email no puede ser nulo")
    @NotBlank()
    private String username;

    @Email(message = "Email no tiene formato valido")
    private String email;

    @Pattern(regexp = "^(?=.*[A-Z])(?=.*[0-9])(?=.*[@#$%^&+=!])(?=\\S+$).{8,16}$")
    private String password;
    
    @NotNull()
    @NotBlank()
    private String nombres;

    @NotNull()
    @NotBlank()
    private String apellidos;

    private MultipartFile avatar;

     public static Usuario buildToEntity(UsuarioRequestDto usuarioRequestDto){
        return Usuario.builder()
        .nombreCompleto(usuarioRequestDto.getNombres()+"-"+usuarioRequestDto.getApellidos())
        .email(usuarioRequestDto.getEmail())
        .password(usuarioRequestDto.getPassword())
        .username(usuarioRequestDto.getUsername())
        .build();
    }

}
