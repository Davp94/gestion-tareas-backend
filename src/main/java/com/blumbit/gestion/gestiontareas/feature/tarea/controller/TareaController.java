package com.blumbit.gestion.gestiontareas.feature.tarea.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.blumbit.gestion.gestiontareas.feature.proyecto.dto.FindProyectoRequestDto;
import com.blumbit.gestion.gestiontareas.feature.proyecto.dto.FindProyectoResponseDto;
import com.blumbit.gestion.gestiontareas.feature.proyecto.dto.ProyectoRequestDto;
import com.blumbit.gestion.gestiontareas.feature.proyecto.dto.ProyectoResponseDto;
import com.blumbit.gestion.gestiontareas.feature.tarea.command.ChangeStateTareaCommand;
import com.blumbit.gestion.gestiontareas.feature.tarea.command.CreateTareaCommand;
import com.blumbit.gestion.gestiontareas.feature.tarea.command.GetTareasUsuarioCommand;
import com.blumbit.gestion.gestiontareas.feature.tarea.dto.ChangeStateTareaDto;
import com.blumbit.gestion.gestiontareas.feature.tarea.dto.TareaRequestDto;
import com.blumbit.gestion.gestiontareas.feature.tarea.dto.TareaResponseDto;

@RestController
@RequestMapping("/tarea")
public class TareaController {

    private final ChangeStateTareaCommand changeStateTareaCommand;

    private final CreateTareaCommand createTareaCommand;

    private final GetTareasUsuarioCommand getTareasUsuarioCommand;

    public TareaController(ChangeStateTareaCommand changeStateTareaCommand, CreateTareaCommand createTareaCommand,
            GetTareasUsuarioCommand getTareasUsuarioCommand) {
        this.changeStateTareaCommand = changeStateTareaCommand;
        this.createTareaCommand = createTareaCommand;
        this.getTareasUsuarioCommand = getTareasUsuarioCommand;
    }

    @GetMapping
    public List<TareaResponseDto> findAllTarea(@ModelAttribute TareaRequestDto tareaRequestDto){
        return getTareasUsuarioCommand.execute(tareaRequestDto);
    }

    @PostMapping
    public TareaResponseDto createTarea(@RequestBody TareaRequestDto tareaRequestDto) {
        return createTareaCommand.execute(tareaRequestDto);
    }

    @PutMapping
    public TareaResponseDto changeStateTarea(@RequestBody ChangeStateTareaDto changeStateTareaDto) {
        return changeStateTareaCommand.execute(changeStateTareaDto);
    }

}
