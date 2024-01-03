package com.microservice.inscripciones.inscripciones.controllers;

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

import com.microservice.inscripciones.inscripciones.models.Inscripcion;
import com.microservice.inscripciones.inscripciones.service.InscripcionService;

@RestController
@RequestMapping("/api/inscripcion/")
public class InscripcionController {
	
	@Autowired
	public InscripcionService insService;
	
	@PostMapping("/save")
	private ResponseEntity<Inscripcion> save (@RequestBody Inscripcion ins){
		Inscripcion temporal = insService.create(ins);
		return ResponseEntity.ok(temporal);
	}
	
	
	@GetMapping("/allList")
	private ResponseEntity<List<Inscripcion>> allList (){
		return ResponseEntity.ok(insService.listCource());
	}

	@GetMapping(value = "{id}")
	private ResponseEntity<Optional<Inscripcion>> user (@PathVariable ("id") Integer id){
		return ResponseEntity.ok(insService.findById(id));
	}
	
	@GetMapping(value = "/course/{id}")
	private ResponseEntity<List<Inscripcion>> course (@PathVariable ("id") Integer id){
		return ResponseEntity.ok(insService.byCourseId(id));
	}
	
	@GetMapping(value = "/user/{id}")
	private ResponseEntity<List<Inscripcion>> person (@PathVariable ("id") Integer id){
		return ResponseEntity.ok(insService.byUserId(id));
	}
}