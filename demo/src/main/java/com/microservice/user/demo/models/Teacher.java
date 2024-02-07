package com.microservice.user.demo.models;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@DiscriminatorValue(value =  "Teacher")
@Table (name = "Teacher")
public class Teacher extends Persona{

	private String numero_aula;
	private String especial;
    
	public Teacher () {
		
	}
	
	public Teacher(Long id, String numero_aula, String especial) {
		this.numero_aula = numero_aula;
		this.especial = especial;
	}

	public String getNumero_aula() {
		return numero_aula;
	}
	public void setNumero_aula(String numero_aula) {
		this.numero_aula = numero_aula;
	}
	public String getEspecial() {
		return especial;
	}
	public void setEspecial(String especial) {
		this.especial = especial;
	}
}
