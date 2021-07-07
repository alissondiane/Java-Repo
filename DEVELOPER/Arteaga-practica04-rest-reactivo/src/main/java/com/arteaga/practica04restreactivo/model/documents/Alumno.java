package com.arteaga.practica04restreactivo.model.documents;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Document(collection="alumnos")
public class Alumno {

	@Id
	private String id;
	private String nombre;
	private String apellido;
	private Date fenac;
	private char sexo;


	public Alumno() {
		super();
	}

	public Alumno(String id, String nombre, String apellido, Date fenac) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.apellido = apellido;
		this.fenac = fenac;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
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

	public Date getFenac() {
		return fenac;
	}

	public void setFenac(Date fenac) {
		this.fenac = fenac;
	}

	public char getSexo() {
		return sexo;
	}

	public void setSexo(char sexo) {
		this.sexo = sexo;
	}
}
