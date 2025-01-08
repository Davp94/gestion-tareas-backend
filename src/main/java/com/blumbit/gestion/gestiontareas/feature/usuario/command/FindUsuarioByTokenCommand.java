package com.blumbit.gestion.gestiontareas.feature.usuario.command;

import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.blumbit.gestion.gestiontareas.feature.usuario.dto.response.UsuarioResponseDto;
import com.blumbit.gestion.gestiontareas.feature.usuario.entity.Usuario;
import com.blumbit.gestion.gestiontareas.feature.usuario.repository.UsuarioRepository;
import com.blumbit.gestion.gestiontareas.util.JwtUtil;

@Service
public class FindUsuarioByTokenCommand {

    private final UsuarioRepository usuarioRepository;

    private final JwtUtil jwtUtil;

    public FindUsuarioByTokenCommand(UsuarioRepository usuarioRepository, JwtUtil jwtUtil) {
        this.usuarioRepository = usuarioRepository;
        this.jwtUtil = jwtUtil;
    }

    public UsuarioResponseDto execute(String token){
        String username = jwtUtil.getUsernameFromToken(token);
        System.out.println(username);
        Usuario usuario = usuarioRepository.findByUsername(username).orElseThrow(() -> new UsernameNotFoundException("usuario no encontrado"));
        return UsuarioResponseDto.buildFromEntity(usuario);
    }
}
