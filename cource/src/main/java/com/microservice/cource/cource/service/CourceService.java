package com.microservice.cource.cource.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.microservice.cource.cource.models.Cource;
import com.microservice.cource.cource.repository.CourceRepository;

@Service
public class CourceService {

	@Autowired
	private CourceRepository couRepository;
	
	public List<Cource> listCource(){
		return couRepository.findAll();
	}
	
	public Cource create (Cource cource) {
		return couRepository.save(cource);
	}
	
	public Optional<Cource> findById(Long id){
		return couRepository.findById(id);
	}
	
}