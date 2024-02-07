package com.clases.clases.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.clases.clases.models.Class;
import com.clases.clases.repository.ClassRepository;

@Service
public class ClassService {

	@Autowired
	private ClassRepository classRepository;
	
	public List<Class> listClass(){
		return classRepository.findAll();
	}
	
	public Class createClaseTema (Class clases) {
		return classRepository.save(clases);
	}
	
	public Optional<Class> findById(Long id){
		return classRepository.findById(id);
	}
	
}