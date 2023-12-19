package com.microservice.user.demo.services;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.microservice.user.demo.feingsUser.Courses;
import com.microservice.user.demo.feingsUser.inscripciones;
import com.microservice.user.demo.models.Course;
import com.microservice.user.demo.models.Inscripciones;
import com.microservice.user.demo.models.Persona;
import com.microservice.user.demo.repository.UserRepository;

@Service
public class userService {
    
    @Autowired
    private UserRepository  userRepository;

    @Autowired
	private inscripciones insFeigns;
	
	@Autowired
	private Courses couFeigns;

    //Persona
    public List<Persona> getAll(){
        return userRepository.findAll();
        }

    public Persona save(Persona use){
        Persona nuevoUser = userRepository.save(use);
        return nuevoUser;
    }

	
	public Optional<Persona> findById(int id){
		return userRepository.findById(id);
	}

    //Cursos
    public Map<String,Optional> getCurso(int courseid){
		Map<String,Optional> result = new HashMap<>();
		Optional<Course> cour = couFeigns.getCour(courseid);
		if(cour.isEmpty()) {
			result.put("Cursos", null);
		}{
			result.put("Cursos:",cour);
		}
		return result;
	}

	public List<Course> getallCource(){
		return couFeigns.allList();
	}

	

    //Inscripciones
	public Inscripciones saveIns(int userId,int courId) {
		Inscripciones ins = new Inscripciones();
		ins.setUserid(userId);
		ins.setCourseid(courId);
		Inscripciones nuIns = insFeigns.save(ins);
		return nuIns;
	} 

	public Map<String,Object> getCourceUser(int userid){
		Map<String,Object> result = new HashMap<>();
		Persona user = userRepository.findById(userid).orElse(null);
		
		if(user ==null) {
			result.put("Mensaje"," El usuario no existe");
			return result;
		}
		
		result.put("Usuario", user);
		List<Inscripciones> ins = insFeigns.getIns(userid);
		if(ins.isEmpty()) {
			result.put("Cursos del  Usuario:", "En ningun Curso");
		}{
			result.put("Cursos del Usuario:",ins);
		}
		return result;
	}

    public Map<String,Object> getCour(int courseid){
		Map<String,Object> result = new HashMap<>();
		
		List<Inscripciones> ins = insFeigns.getCou(courseid);
		if(ins.isEmpty()) {
			result.put("Curso Integrantes", "Ningun estudiante");
		}{
			result.put("Curso Integrantes:",ins);
		}
		return result;
	}

}
