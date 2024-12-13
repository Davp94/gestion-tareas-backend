package com.blumbit.gestion.gestiontareas.feature.tarea.repository;

import org.springframework.data.repository.ListCrudRepository;

import com.blumbit.gestion.gestiontareas.feature.tarea.entity.Tarea;
import java.util.List;


public interface TareaRepository extends ListCrudRepository<Tarea, Integer>{

    List<Tarea> findByProyecto_IdAndUsuario_Id(Short proyectoId, Integer usuarioId);

}
