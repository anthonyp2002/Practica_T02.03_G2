package com.microservice.cource.cource.repository;

import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;
import org.springframework.stereotype.Repository;

import com.microservice.cource.cource.models.Cource;

@Repository
public interface CourceRepository extends JpaRepositoryImplementation<Cource,Long>{

}
