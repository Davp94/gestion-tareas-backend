package com.blumbit.gestion.gestiontareas.feature.usuario.command;

import org.springframework.stereotype.Component;

import com.blumbit.gestion.gestiontareas.feature.usuario.entity.Usuario;
import com.blumbit.gestion.gestiontareas.feature.usuario.repository.UsuarioRepository;

@Component
public class UpdateUsuarioCommand {

    private final UsuarioRepository usuarioRepository;

    public UpdateUsuarioCommand(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    public Usuario execute(Usuario usuario, Integer id) {
        Usuario usuarioRetrieved = usuarioRepository.findById(id).get();
        usuarioRetrieved.setAvatar(usuario.getAvatar());
        usuarioRetrieved.setEmail(usuario.getEmail());
        usuarioRetrieved.setUsername(usuario.getUsername());
        
        return usuarioRepository.save(usuarioRetrieved);
    }

}
