package com.microservice.user.demo.feingsUser;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.microservice.user.demo.models.Class;

@FeignClient(name = "class-service",url="http://localhost:8004")
public interface ClassFeings {

	@PostMapping("/api/class/save")
	public Class createClaseTema(@RequestBody Class clases);
	
	@GetMapping("/api/class/allList")
	public List<Class> allList();
	
	@GetMapping("/api/class/class/{id}")
	public List<Class> getClases(@PathVariable ("id") Integer id);
	
} 
