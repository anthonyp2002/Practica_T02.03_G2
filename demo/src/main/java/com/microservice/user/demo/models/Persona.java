package com.microservice.user.demo.models;

import jakarta.persistence.DiscriminatorColumn;
import jakarta.persistence.DiscriminatorType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "person",discriminatorType = DiscriminatorType.STRING)
public class Persona {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)	
	private Long id;
	
	private String nombre;
	private String apellido;
	private String cedula;
	private String fe_nacimi;
	private String sexo;
	private String dirrecion;		
	private String telefono;
	
	public Persona () {
		
	}
	
	public Persona(Long id, String nombre, String apellido, String cedula, String fe_nacimi,String sexo,String dirrecion,String telefono ) {
		this.id = id;
		this.nombre = nombre;
		this.apellido = apellido;
		this.cedula = cedula;
		this.fe_nacimi = fe_nacimi;
		this.cedula = cedula;
		this.sexo = sexo;
		this.telefono = telefono;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public String getCedula() {
		return cedula;
	}
	public void setCedula(String cedula) {
		this.cedula = cedula;
	}
	public String getSexo() {
		return sexo;
	}
	public void setSexo(String sexo) {
		this.sexo = sexo;
	}
	public String getFe_nacimi() {
		return fe_nacimi;
	}
	public void setFe_nacimi(String fe_nacimi) {
		this.fe_nacimi = fe_nacimi;
	}
	public String getDirrecion() {
		return dirrecion;
	}
	public void setDirrecion(String dirrecion) {
		this.dirrecion = dirrecion;
	}
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}	
}