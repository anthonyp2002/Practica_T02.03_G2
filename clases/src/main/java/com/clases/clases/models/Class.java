package com.clases.clases.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Class {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private Long horaInicio;
	private Long horaAcabado;
	private String tema;
	private int id_tarea;
	public Class() {
		
	}

	public Class(int id, Long horaInicio, Long horaAcabado, String tema,int id_tarea) {
		super();
		this.id = id;
		this.horaInicio = horaInicio;
		this.horaAcabado = horaAcabado;
		this.tema = tema;
		this.id_tarea = id_tarea;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Long getHoraInicio() {
		return horaInicio;
	}

	public void setHoraInicio(Long horaInicio) {
		this.horaInicio = horaInicio;
	}

	public Long getHoraAcabado() {
		return horaAcabado;
	}

	public void setHoraAcabado(Long horaAcabado) {
		this.horaAcabado = horaAcabado;
	}

	public String getTema() {
		return tema;
	}

	public void setTema(String tema) {
		this.tema = tema;
	}
	
		public int getIdTarea() {
		return id_tarea;
	}

	public void setIdTarea(int id_tarea) {
		this.id_tarea = id_tarea;
	}
	
	
	
}

