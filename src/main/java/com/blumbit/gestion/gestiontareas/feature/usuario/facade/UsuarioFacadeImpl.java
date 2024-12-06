package com.blumbit.gestion.gestiontareas.feature.usuario.facade;

import java.util.List;

import com.blumbit.gestion.gestiontareas.feature.usuario.dto.request.UsuarioRequestDto;
import com.blumbit.gestion.gestiontareas.feature.usuario.dto.response.UsuarioResponseDto;

public class UsuarioFacadeImpl implements UsuarioFacade{

    @Override
    public UsuarioResponseDto findById(Integer id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findById'");
    }

    @Override
    public List<UsuarioResponseDto> findAllUsuarios() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findAllUsuarios'");
    }

    @Override
    public UsuarioResponseDto createUsuario(UsuarioRequestDto usuarioRequestDto) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'createUsuario'");
    }

    @Override
    public UsuarioResponseDto updateUsuario(UsuarioRequestDto usuarioRequestDto, Integer id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'updateUsuario'");
    }

    @Override
    public void deleteUsuario(Integer id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'deleteUsuario'");
    }

}
