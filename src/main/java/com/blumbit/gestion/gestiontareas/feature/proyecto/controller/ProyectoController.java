package com.blumbit.gestion.gestiontareas.feature.proyecto.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.blumbit.gestion.gestiontareas.feature.proyecto.command.CreateProyectoCommand;
import com.blumbit.gestion.gestiontareas.feature.proyecto.command.FindProyectosUsuarioCommand;
import com.blumbit.gestion.gestiontareas.feature.proyecto.dto.FindProyectoRequestDto;
import com.blumbit.gestion.gestiontareas.feature.proyecto.dto.FindProyectoResponseDto;
import com.blumbit.gestion.gestiontareas.feature.proyecto.dto.ProyectoRequestDto;
import com.blumbit.gestion.gestiontareas.feature.proyecto.dto.ProyectoResponseDto;

@RestController
@RequestMapping("/proyecto")
public class ProyectoController {

    private final CreateProyectoCommand createProyectoCommand;

    private final FindProyectosUsuarioCommand findProyectosUsuarioCommand;

    public ProyectoController(CreateProyectoCommand createProyectoCommand,
            FindProyectosUsuarioCommand findProyectosUsuarioCommand) {
        this.createProyectoCommand = createProyectoCommand;
        this.findProyectosUsuarioCommand = findProyectosUsuarioCommand;
    }

    @GetMapping
    public List<FindProyectoResponseDto> findProyectoByUsuario(@RequestParam Integer usuarioId){
        return findProyectosUsuarioCommand.execute(usuarioId);
    }

    @PostMapping
    public ProyectoResponseDto createUsuario(@RequestBody ProyectoRequestDto proyectoRequestDto) {
        return createProyectoCommand.execute(proyectoRequestDto);
    }

    

}
