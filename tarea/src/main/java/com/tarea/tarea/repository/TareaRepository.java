package com.tarea.tarea.repository;

import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;
import org.springframework.stereotype.Repository;

import com.tarea.tarea.model.Tarea;

@Repository
public interface TareaRepository extends JpaRepositoryImplementation<Tarea,Long>{

}
