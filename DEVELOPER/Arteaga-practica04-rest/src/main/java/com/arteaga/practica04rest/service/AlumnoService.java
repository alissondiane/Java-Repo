package com.arteaga.practica04rest.service;

import com.arteaga.practica04rest.model.entity.Alumno;

import java.util.List;

public interface AlumnoService {
	public void save(Alumno alumno);
	//public void actualizar(Alumno alumno);
	public void delete(Alumno alumno);
	
	public Alumno findById(String id);
	public List<Alumno> findAll();
	

}
