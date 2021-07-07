package com.arteaga.practica04rest.model.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Date;

import static javax.persistence.TemporalType.TIMESTAMP;

@Entity
@Table(name = "curso", catalog = "escuela")
@EntityListeners(AuditingEntityListener.class)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Curso {

	@Id
	@Column(name = "chrCurCodigo", unique = true, nullable = false)
	private String id;
	@Column(name = "vchCurNombre", length = 50)
	private String nombre;
	@Column(name = "intCurCreditos")
	private Integer creditos;

	@CreatedDate
	@Column(name = "created_date")
	//@Temporal(TIMESTAMP)
	@JsonFormat(pattern = "dd-MM-yyyy HH:mm:ss")
	private LocalDateTime createdDate;

	@LastModifiedDate
	@Column(name = "last_modified_date")
	//@Temporal(TIMESTAMP)
	@JsonFormat(pattern = "dd-MM-yyyy HH:mm:ss")
	private LocalDateTime lastModifiedDate;

	/*
	@CreatedDate
	@Column(name = "created_date")
	@Temporal(TIMESTAMP)
	protected Date createdDate;

	@LastModifiedDate
	@Temporal(TIMESTAMP)
	@Column(name = "last_modified_date")
	protected Date lastModifiedDate;

*/

	/*
	public Curso() {
		super();
	}

	public Curso(String id, String nombre, Integer creditos) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.creditos = creditos;
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

	public Integer getCreditos() {
		return creditos;
	}

	public void setCreditos(Integer creditos) {
		this.creditos = creditos;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public Date getLastModifiedDate() {
		return lastModifiedDate;
	}

	public void setLastModifiedDate(Date lastModifiedDate) {
		this.lastModifiedDate = lastModifiedDate;
	}
	*/

}
