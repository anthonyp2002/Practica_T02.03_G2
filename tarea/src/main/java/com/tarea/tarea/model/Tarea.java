package com.tarea.tarea.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Tarea{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String tema;

	public Tarea() {
		
	}

	public Tarea(int id,String tema) {
		super();
		this.id = id;
		this.tema = tema;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}


	public String getTema() {
		return tema;
	}

	public void setTema(String tema) {
		this.tema = tema;
	}
	
	
}

