package com.blumbit.gestion.gestiontareas.feature.usuario.command;

import org.springframework.stereotype.Service;
import com.blumbit.gestion.gestiontareas.feature.usuario.entity.Usuario;
import com.blumbit.gestion.gestiontareas.feature.usuario.repository.UsuarioRepository;

@Service
public class CreateUsuarioCommand {

    private final UsuarioRepository usuarioRepository;

    public CreateUsuarioCommand(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    public Usuario execute(Usuario usuario) {
        try {
            Usuario usuarioCreated = usuarioRepository.save(usuario);
            return usuarioCreated;
        } catch (Exception e) {
            throw new RuntimeException("Error al crear el usuario");
        }
    }
}
