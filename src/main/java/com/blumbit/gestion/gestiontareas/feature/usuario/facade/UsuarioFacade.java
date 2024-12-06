package com.blumbit.gestion.gestiontareas.feature.usuario.facade;

import java.util.List;

import com.blumbit.gestion.gestiontareas.feature.usuario.dto.request.UsuarioRequestDto;
import com.blumbit.gestion.gestiontareas.feature.usuario.dto.response.UsuarioResponseDto;

public interface UsuarioFacade {
    UsuarioResponseDto findById(Integer id);
    List<UsuarioResponseDto> findAllUsuarios();
    UsuarioResponseDto createUsuario(UsuarioRequestDto usuarioRequestDto);
    UsuarioResponseDto updateUsuario(UsuarioRequestDto usuarioRequestDto, Integer id);
    void deleteUsuario(Integer id);
}
