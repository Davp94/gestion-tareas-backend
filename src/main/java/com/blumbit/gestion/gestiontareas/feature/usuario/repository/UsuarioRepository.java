package com.blumbit.gestion.gestiontareas.feature.usuario.repository;

import java.util.Optional;

import org.springframework.data.repository.ListCrudRepository;
import com.blumbit.gestion.gestiontareas.feature.usuario.entity.Usuario;

public interface UsuarioRepository extends ListCrudRepository<Usuario, Integer>{

    Optional<Usuario> findByUsername(String username);

    // //QUERY METHODS
    // Optional<Usuario> findUsuarioByEmail(String email);

    // //SQL 
    // @Query(value = "select * from Usuario where usu_username like ?1", nativeQuery = true)
    // Optional<Usuario> buscarUsuarioPorUsername(String username);

    // //JPQL 
    // @Query(value = "select usuario from Usuario where username like ?1")
    // Optional<Usuario> buscarUsuarioPorUsernameJpql(String username);
}
