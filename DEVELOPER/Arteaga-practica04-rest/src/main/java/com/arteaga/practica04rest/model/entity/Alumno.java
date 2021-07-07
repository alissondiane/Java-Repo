package com.arteaga.practica04rest.model.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Table(name = "alumno", catalog = "escuela")
public class Alumno {

	@Id
	@Column(name = "chrAluCodigo", unique = true, nullable = false)
	private String id;
	@Column(name = "vchAluNombres")
	private String nombre;
	@Column(name = "vchAluApellidos")
	private String apellido;
	@Column(name = "dtmAluFechaNac")
	@Temporal(TemporalType.DATE)
	private Date fenac;

	@Column(name = "chrAluSexo")
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
