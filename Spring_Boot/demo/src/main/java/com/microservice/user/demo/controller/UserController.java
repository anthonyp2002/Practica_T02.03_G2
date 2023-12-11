package com.microservice.user.demo.controller;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.microservice.user.demo.models.Course;
import com.microservice.user.demo.models.Inscripciones;
import com.microservice.user.demo.models.User;
import com.microservice.user.demo.services.userService;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private userService  userService;

    //Person
    @GetMapping
    public ResponseEntity<List<User>> listarUser(){
        List<User> use = userService.getAll();
        if(use.isEmpty()){
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(use);
    }

	@PostMapping("/save")
	public ResponseEntity<User> save (@RequestBody User us){
		User use = userService.save(us);
		return ResponseEntity.ok(use);
	}

    @GetMapping(value = "{id}")
	private ResponseEntity<Optional<User>> user (@PathVariable ("id") int id){
		return ResponseEntity.ok(userService.findById(id));
	}

    //Cursos
    @GetMapping("/getCurso/{id}")
	public ResponseEntity<Map<String, Optional>> getCou(@PathVariable("id") int id){
		Map<String,Optional> result = userService.getCurso(id);
		return ResponseEntity.ok(result);
	}

    @GetMapping("/getCursoall")
    public ResponseEntity<List<Course>> listallCource(){
        List<Course> cou = userService.getallCource();
        if(cou.isEmpty()){
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(cou);
    }
    


    //Inscripciones
    @PostMapping("/inscripciones/save")
	public ResponseEntity<Inscripciones> saveIns(@RequestBody Inscripciones ins){
		Inscripciones nueIns = userService.saveIns(ins.getUserid(), ins.getCourseid());
		return ResponseEntity.ok(nueIns);
	} 

	@GetMapping("/getCursos/{id}")
	public ResponseEntity<Map<String, Object>> listCursos(@PathVariable("id") int id){
		Map<String,Object> result = userService.getCourceUser(id);
		return ResponseEntity.ok(result);
	}

    @GetMapping("/getCourse/{id}")
	public ResponseEntity<Map<String, Object>> listCourse(@PathVariable("id") int id){
		Map<String,Object> result = userService.getCour(id);
		return ResponseEntity.ok(result);
	}
}
