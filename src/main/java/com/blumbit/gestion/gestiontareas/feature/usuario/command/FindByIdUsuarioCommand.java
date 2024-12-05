package com.blumbit.gestion.gestiontareas.feature.usuario.command;

import org.springframework.stereotype.Component;

import com.blumbit.gestion.gestiontareas.common.Command;
import com.blumbit.gestion.gestiontareas.feature.usuario.entity.Usuario;
import com.blumbit.gestion.gestiontareas.feature.usuario.repository.UsuarioRepository;

@Component
public class FindByIdUsuarioCommand implements Command<Usuario>{

    private final UsuarioRepository usuarioRepository;

    private Integer userId;

    public FindByIdUsuarioCommand(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    public FindByIdUsuarioCommand setUserId(Integer userId) {
        this.userId = userId;
        return this;
    }

    @Override
    public Usuario execute() {
        if(userId == null){
            throw new RuntimeException("Id de usuario no puede ser nulo");
        }
        return usuarioRepository.findById(userId).get();
    }

    //METODOS PROPIOS

}
