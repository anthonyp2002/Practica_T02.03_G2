package com.clases.clases.repository;

import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;
import org.springframework.stereotype.Repository;

import com.clases.clases.models.Class;

@Repository
public interface ClassRepository extends JpaRepositoryImplementation<Class,Long>{

}
