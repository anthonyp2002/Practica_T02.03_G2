package com.microservice.user.demo.feingsUser;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.microservice.user.demo.models.Tarea;

@FeignClient(name = "tarea-service",url="http://localhost:8005")
public interface TareaFeings {

    @PostMapping("/api/tarea/save")
	public Tarea createTarea(@RequestBody Tarea tare);
	
	@GetMapping("/api/tarea/allList")
	public List<Tarea> allList();
	
	@GetMapping("/api/tarea/tarea/{id}")
	public List<Tarea> getClases(@PathVariable ("id") Integer id);
	
}
