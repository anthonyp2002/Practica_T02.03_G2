package com.microservice.user.demo.models;

public class Tarea {
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
