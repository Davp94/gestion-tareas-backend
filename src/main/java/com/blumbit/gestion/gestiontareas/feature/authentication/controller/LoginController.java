package com.blumbit.gestion.gestiontareas.feature.authentication.controller;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
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


    private final JwtUtil jwtUtil;

    private final UserDetailsService userDetailsService;


    public LoginController(JwtUtil jwtUtil,
            UserDetailsService userDetailsService) {
        this.jwtUtil = jwtUtil;
        this.userDetailsService = userDetailsService;
    }

    @PostMapping()
    public LoginResponseDto login(@RequestBody LoginRequestDto loginRequestDto){
        UsernamePasswordAuthenticationToken login = new UsernamePasswordAuthenticationToken(loginRequestDto.getUsername(), loginRequestDto.getPassword());
        UserDetails userDetails = userDetailsService
            .loadUserByUsername(loginRequestDto.getUsername());
        String jwt = jwtUtil.generateToken(userDetails);
        return LoginResponseDto.builder().token(jwt).build();
    }


}
