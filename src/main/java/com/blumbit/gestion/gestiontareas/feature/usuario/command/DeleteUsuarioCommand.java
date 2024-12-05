package com.blumbit.gestion.gestiontareas.feature.usuario.command;

import org.springframework.stereotype.Component;

import com.blumbit.gestion.gestiontareas.feature.usuario.repository.UsuarioRepository;

@Component
public class DeleteUsuarioCommand {

    private final UsuarioRepository usuarioRepository;

    public DeleteUsuarioCommand(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    public void execute(Integer id) {
        usuarioRepository.deleteById(id);
    }

}
