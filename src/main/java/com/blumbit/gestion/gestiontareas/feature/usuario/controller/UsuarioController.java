package com.blumbit.gestion.gestiontareas.feature.usuario.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.blumbit.gestion.gestiontareas.feature.usuario.command.CreateUsuarioCommand;
import com.blumbit.gestion.gestiontareas.feature.usuario.command.DeleteUsuarioCommand;
import com.blumbit.gestion.gestiontareas.feature.usuario.command.FindAllUsuarioCommand;
import com.blumbit.gestion.gestiontareas.feature.usuario.command.FindByIdUsuarioCommand;
import com.blumbit.gestion.gestiontareas.feature.usuario.command.UpdateUsuarioCommand;
import com.blumbit.gestion.gestiontareas.feature.usuario.entity.Usuario;
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

    public UsuarioController(CreateUsuarioCommand createUsuarioCommand, UpdateUsuarioCommand updateUsuarioCommand,
            DeleteUsuarioCommand deleteUsuarioCommand, FindAllUsuarioCommand findAllUsuarioCommand,
            FindByIdUsuarioCommand findByIdUsuarioCommand) {
        this.createUsuarioCommand = createUsuarioCommand;
        this.updateUsuarioCommand = updateUsuarioCommand;
        this.deleteUsuarioCommand = deleteUsuarioCommand;
        this.findAllUsuarioCommand = findAllUsuarioCommand;
        this.findByIdUsuarioCommand = findByIdUsuarioCommand;
    }

    @GetMapping
    public List<Usuario> findAllUsuarios(){
        return findAllUsuarioCommand.execute();
    }

    @GetMapping("/{id}")
    public Usuario findUsuarioById(@PathVariable Integer id){
        findByIdUsuarioCommand.setUserId(id);
        return findByIdUsuarioCommand.execute();
    }
    
    @PostMapping
    public Usuario createUsuario(@RequestBody Usuario usuario) {
        return createUsuarioCommand.execute(usuario);
    }

    @PutMapping("/{id}")
    public Usuario actualizarUsuario(@RequestBody Usuario usuario,@PathVariable Integer id) {
        return updateUsuarioCommand.execute(usuario, id);
    }

    @DeleteMapping("/{id}")
    public void eliminarUsuario(@PathVariable Integer id){
        deleteUsuarioCommand.execute(id);
    }
    


}
