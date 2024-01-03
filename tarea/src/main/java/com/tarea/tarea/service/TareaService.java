package com.tarea.tarea.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tarea.tarea.model.Tarea;
import com.tarea.tarea.repository.TareaRepository;

@Service
public class TareaService {

	@Autowired
	private TareaRepository tareRepository;
	
	public List<Tarea> listTare(){
		return tareRepository.findAll();
	}
	
	public Tarea createTareTema (Tarea tare) {
		return tareRepository.save(tare);
	}
	
	public Optional<Tarea> findById(Long id){
		return tareRepository.findById(id);
	}
	
}