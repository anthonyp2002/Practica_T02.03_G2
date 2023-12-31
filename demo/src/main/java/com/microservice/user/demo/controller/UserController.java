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
import com.microservice.user.demo.models.Persona;
import com.microservice.user.demo.models.Student;
import com.microservice.user.demo.models.Tarea;
import com.microservice.user.demo.models.Teacher;
import com.microservice.user.demo.models.Class;
import com.microservice.user.demo.services.userService;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private userService  userService;

    //Person
    @GetMapping
    public ResponseEntity<List<Persona>> listarUser(){
        List<Persona> use = userService.getAll();
        if(use.isEmpty()){
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(use);
    }

	@PostMapping("/save/student")
	public ResponseEntity<Student> save (@RequestBody Student us){
		Student use = userService.save(us);
		return ResponseEntity.ok(use);
	}

    @PostMapping("/save/teacher")
	public ResponseEntity<Teacher> save (@RequestBody Teacher us){
		Teacher use = userService.saveT(us);
		return ResponseEntity.ok(use);
	}

    @GetMapping(value = "{id}")
	private ResponseEntity<Optional<Persona>> user (@PathVariable ("id") int id){
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

	//Clases
    @PostMapping("/class/save")
	public ResponseEntity<Class> saveClass(@RequestBody Class cl){
		Class nueClas = userService.saveClass(cl);
		return ResponseEntity.ok(nueClas);
	} 

	
    @GetMapping("class/getClassall")
    public ResponseEntity<List<Class>> listallClass(){
        List<Class> cou = userService.getallClass();
        if(cou.isEmpty()){
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(cou);
    }

	//Tarea
    @PostMapping("/tarea/save")
	public ResponseEntity<Tarea> saveTarea(@RequestBody Tarea ta){
		Tarea tare = userService.saveTare(ta);
		return ResponseEntity.ok(tare);
	} 

	
    @GetMapping("tarea/getTareasall")
    public ResponseEntity<List<Tarea>> listallTare(){
        List<Tarea> tare = userService.getallTare();
        if(tare.isEmpty()){
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(tare);
    }	

}
