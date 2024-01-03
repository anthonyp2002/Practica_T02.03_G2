package com.tarea.tarea.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tarea.tarea.service.TareaService;
import com.tarea.tarea.model.Tarea;



@RestController
@RequestMapping("api/tarea/")
public class TareaController {
	
	@Autowired
	public TareaService taService;
	
	@PostMapping("/save")
	private ResponseEntity<Tarea> createClaseTema (@RequestBody Tarea tare){
		Tarea temporal = taService.createTareTema(tare);
		return ResponseEntity.ok(temporal);
	}
	
	
	@GetMapping("/allList")
	private ResponseEntity<List<Tarea>> allList (){
		return ResponseEntity.ok(taService.listTare());
	}

	@GetMapping("tarea/{id}")
	private ResponseEntity<Optional<Tarea>> user (@PathVariable ("id") Long id){
		return ResponseEntity.ok(taService.findById(id));
	}
}