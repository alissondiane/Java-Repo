package com.arteaga.practica04rest.service;

import com.arteaga.practica04rest.model.entity.Curso;

import java.util.List;

public interface CursoService {
	public void save(Curso curso);
	//public void actualizar(Curso curso);
	public void delete(Curso curso);
	
	public Curso findById(String id);
	public List<Curso> findAll();
	

}
