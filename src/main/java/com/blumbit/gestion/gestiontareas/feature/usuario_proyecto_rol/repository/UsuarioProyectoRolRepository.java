package com.blumbit.gestion.gestiontareas.feature.usuario_proyecto_rol.repository;

import java.util.List;

import org.springframework.data.repository.ListCrudRepository;

import com.blumbit.gestion.gestiontareas.feature.usuario_proyecto_rol.entity.UsuarioProyectoRol;

public interface UsuarioProyectoRolRepository extends ListCrudRepository<UsuarioProyectoRol, Short>{

    List<UsuarioProyectoRolRepository> findByUsuario_id(Integer usuarioId);
}
