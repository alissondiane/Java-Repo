package com.arteaga.practica04restreactivo.service.impl;

import com.arteaga.practica04restreactivo.model.daos.AlumnoDao;
import com.arteaga.practica04restreactivo.model.documents.Alumno;
import com.arteaga.practica04restreactivo.service.AlumnoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class AlumnoServiceImpl implements AlumnoService {

	@Autowired
	private AlumnoDao dao;

	@Override
	public Flux<Alumno> findAll() {
		return dao.findAll();
	}

	@Override
	public Mono<Alumno> findById(String id) {
		return dao.findById(id);
	}

	@Override
	public Mono<Alumno> save(Alumno alumno) {
		return dao.save(alumno);
	}

	@Override
	public Mono<Void> deleteById(String id) {
		return dao.deleteById(id);
	}
	
	
}
