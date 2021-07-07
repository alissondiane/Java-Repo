package com.arteaga.practica04rest.service.impl;

import com.arteaga.practica04rest.model.entity.Alumno;
import com.arteaga.practica04rest.model.persistence.AlumnoRepository;
import com.arteaga.practica04rest.service.AlumnoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class AlumnoServiceImpl implements AlumnoService {

	@Autowired
	AlumnoRepository repositorio;
	
	@Override
	@Transactional(readOnly = true)
	public List<Alumno> findAll() {
		return (List<Alumno>) repositorio.findAll();
	}

	@Override
	@Transactional
	public void save(Alumno alumno) {
		repositorio.save(alumno);
	}

	@Override
	@Transactional(readOnly = true)
	public Alumno findById(String id) {
		return repositorio.findById(id).orElse(null);
	}

	@Override
	@Transactional
	public void delete(Alumno alumno) {
		repositorio.delete(alumno);

	}
	
	
}
