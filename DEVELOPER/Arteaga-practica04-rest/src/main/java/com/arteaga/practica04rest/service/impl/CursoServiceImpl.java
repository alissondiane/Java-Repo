package com.arteaga.practica04rest.service.impl;

import com.arteaga.practica04rest.model.entity.Curso;
import com.arteaga.practica04rest.model.persistence.CursoRepository;
import com.arteaga.practica04rest.service.CursoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CursoServiceImpl implements CursoService {

	@Autowired
	CursoRepository repositorio;
	
	@Override
	@Transactional(readOnly = true)
	public List<Curso> findAll() {
		return (List<Curso>) repositorio.findAll();
	}

	@Override
	@Transactional
	public void save(Curso curso) {
		repositorio.save(curso);
	}

	@Override
	@Transactional(readOnly = true)
	public Curso findById(String id) {
		return repositorio.findById(id).orElse(null);
	}

	@Override
	@Transactional
	public void delete(Curso curso) {
		repositorio.delete(curso);
		
	}
	
	
}
