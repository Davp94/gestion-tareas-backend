package com.blumbit.gestion.gestiontareas.feature.authentication.controller;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.blumbit.gestion.gestiontareas.feature.authentication.dto.LoginRequestDto;
import com.blumbit.gestion.gestiontareas.feature.authentication.dto.LoginResponseDto;
import com.blumbit.gestion.gestiontareas.util.JwtUtil;

@RestController
@RequestMapping("/login")
public class LoginController {

    private final AuthenticationManager authenticationManager;

    private final JwtUtil jwtUtil;

    public LoginController(AuthenticationManager authenticationManager, JwtUtil jwtUtil) {
        this.authenticationManager = authenticationManager;
        this.jwtUtil = jwtUtil;
    }

    @PostMapping()
    public LoginResponseDto login(@RequestBody LoginRequestDto loginRequestDto){
        UsernamePasswordAuthenticationToken login = new UsernamePasswordAuthenticationToken(loginRequestDto.getUsername(), loginRequestDto.getPassword());
        Authentication authentication = authenticationManager.authenticate(login);
        String jwt = jwtUtil.createToken(loginRequestDto.getUsername());
        return LoginResponseDto.builder().token(jwt).build();
    }


}
