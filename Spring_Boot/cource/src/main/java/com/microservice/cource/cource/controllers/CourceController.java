package com.microservice.cource.cource.controllers;

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

import com.microservice.cource.cource.models.Cource;
import com.microservice.cource.cource.service.CourceService;

@RestController
@RequestMapping("api/cource/")
public class CourceController {
	
	@Autowired
	public CourceService couService;
	
	@PostMapping("/save")
	private ResponseEntity<Cource> save (@RequestBody Cource cou){
		Cource temporal = couService.create(cou);
		
		return ResponseEntity.ok(temporal);
	}
	
	
	@GetMapping("/allList")
	private ResponseEntity<List<Cource>> allList (){
		return ResponseEntity.ok(couService.listCource());
	}

	@GetMapping("curso/{id}")
	private ResponseEntity<Optional<Cource>> user (@PathVariable ("id") Long id){
		return ResponseEntity.ok(couService.findById(id));
	}
}