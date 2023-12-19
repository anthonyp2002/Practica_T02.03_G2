package com.microservice.user.demo.models;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@DiscriminatorValue(value =  "Student")
@Table (name = "Student")
public class Student extends Persona{
    
	private String ciclo;
    
	public Student () {
		
	}
	
	public Student(String ciclo) {
		this.ciclo = ciclo;
	}

	public String getCiclo() {
		return ciclo;
	}
	public void setCiclo(String ciclo) {
		this.ciclo = ciclo;
	}

}
