package com.clases.clases.controllers;

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

import com.clases.clases.service.ClassService;
import com.clases.clases.models.Class;



@RestController
@RequestMapping("api/class/")
public class ClassController {
	
	@Autowired
	public ClassService classService;
	
	@PostMapping("/save")
	private ResponseEntity<Class> createClaseTema (@RequestBody Class clases){
		Class temporal = classService.createClaseTema(clases);
		return ResponseEntity.ok(temporal);
	}
	
	
	@GetMapping("/allList")
	private ResponseEntity<List<Class>> allList (){
		return ResponseEntity.ok(classService.listClass());
	}

	@GetMapping("class/{id}")
	private ResponseEntity<Optional<Class>> user (@PathVariable ("id") Long id){
		return ResponseEntity.ok(classService.findById(id));
	}
}