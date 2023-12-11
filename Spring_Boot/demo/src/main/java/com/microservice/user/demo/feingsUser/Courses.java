package com.microservice.user.demo.feingsUser;

import java.util.List;
import java.util.Optional;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.microservice.user.demo.models.Course;

@FeignClient(name = "course-service",url="http://localhost:8002")
public interface Courses {
	
	@GetMapping("/api/cource/curso/{id}")
	public Optional<Course> getCour(@PathVariable ("id") Integer id);

	@GetMapping("/api/cource/allList")
	public List<Course> allList();
}
