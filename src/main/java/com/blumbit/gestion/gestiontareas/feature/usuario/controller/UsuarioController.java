package com.blumbit.gestion.gestiontareas.feature.usuario.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.blumbit.gestion.gestiontareas.feature.usuario.command.CreateUsuarioCommand;
import com.blumbit.gestion.gestiontareas.feature.usuario.command.DeleteUsuarioCommand;
import com.blumbit.gestion.gestiontareas.feature.usuario.command.FindAllUsuarioCommand;
import com.blumbit.gestion.gestiontareas.feature.usuario.command.FindByIdUsuarioCommand;
import com.blumbit.gestion.gestiontareas.feature.usuario.command.FindUsuarioByTokenCommand;
import com.blumbit.gestion.gestiontareas.feature.usuario.command.UpdateUsuarioCommand;
import com.blumbit.gestion.gestiontareas.feature.usuario.dto.request.UsuarioRequestDto;
import com.blumbit.gestion.gestiontareas.feature.usuario.dto.response.UsuarioResponseDto;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {

    private final CreateUsuarioCommand createUsuarioCommand;

    private final UpdateUsuarioCommand updateUsuarioCommand;

    private final DeleteUsuarioCommand deleteUsuarioCommand;

    private final FindAllUsuarioCommand findAllUsuarioCommand;

    private final FindByIdUsuarioCommand findByIdUsuarioCommand;

    private final FindUsuarioByTokenCommand findUsuarioByToken;

    public UsuarioController(CreateUsuarioCommand createUsuarioCommand, UpdateUsuarioCommand updateUsuarioCommand,
            DeleteUsuarioCommand deleteUsuarioCommand, FindAllUsuarioCommand findAllUsuarioCommand,
            FindByIdUsuarioCommand findByIdUsuarioCommand, FindUsuarioByTokenCommand findUsuarioByToken) {
        this.createUsuarioCommand = createUsuarioCommand;
        this.updateUsuarioCommand = updateUsuarioCommand;
        this.deleteUsuarioCommand = deleteUsuarioCommand;
        this.findAllUsuarioCommand = findAllUsuarioCommand;
        this.findByIdUsuarioCommand = findByIdUsuarioCommand;
        this.findUsuarioByToken = findUsuarioByToken;
    }

    @GetMapping
    public List<UsuarioResponseDto> findAllUsuarios(){
        return findAllUsuarioCommand.execute();
    }

    @GetMapping("/{id}")
    public UsuarioResponseDto findUsuarioById(@PathVariable Integer id){
        findByIdUsuarioCommand.setUserId(id);
        return findByIdUsuarioCommand.execute();
    }

    @GetMapping("/token")
    public UsuarioResponseDto findUsuarioByToken(@RequestParam String token){
        return findUsuarioByToken.execute(token);
    }
    
    @PostMapping
    public UsuarioResponseDto createUsuario(@ModelAttribute UsuarioRequestDto usuarioRequestDto) {
        return createUsuarioCommand.execute(usuarioRequestDto);
    }

    @PutMapping("/{id}")
    public UsuarioResponseDto actualizarUsuario(@RequestBody UsuarioRequestDto usuario,@PathVariable Integer id) {
        return updateUsuarioCommand.execute(usuario, id);
    }

    @DeleteMapping("/{id}")
    public void eliminarUsuario(@PathVariable Integer id){
        deleteUsuarioCommand.execute(id);
    }
    


}
