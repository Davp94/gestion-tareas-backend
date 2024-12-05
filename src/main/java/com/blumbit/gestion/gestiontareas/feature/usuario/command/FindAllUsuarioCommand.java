package com.blumbit.gestion.gestiontareas.feature.usuario.command;

import java.util.List;

import org.springframework.stereotype.Component;

import com.blumbit.gestion.gestiontareas.common.Command;
import com.blumbit.gestion.gestiontareas.feature.usuario.entity.Usuario;
import com.blumbit.gestion.gestiontareas.feature.usuario.repository.UsuarioRepository;

@Component
public class FindAllUsuarioCommand implements Command<List<Usuario>>{

    private final UsuarioRepository usuarioRepository;

    public FindAllUsuarioCommand(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }
    @Override
    public List<Usuario> execute() {
        return usuarioRepository.findAll();
    }

}
