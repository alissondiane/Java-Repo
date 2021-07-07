package com.arteaga.practica04restreactivo.service.impl;

import com.arteaga.practica04restreactivo.model.daos.AlumnoDao;
import com.arteaga.practica04restreactivo.model.daos.CursoDao;
import com.arteaga.practica04restreactivo.model.documents.Alumno;
import com.arteaga.practica04restreactivo.model.documents.Curso;
import com.arteaga.practica04restreactivo.service.CursoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class CursoServiceImpl implements CursoService {
	@Autowired
	private CursoDao dao;

	@Override
	public Flux<Curso> findAll() {
		return dao.findAll();
	}

	@Override
	public Mono<Curso> findById(String id) {
		return dao.findById(id);
	}

	@Override
	public Mono<Curso> save(Curso curso) {
		return dao.save(curso);
	}

	@Override
	public Mono<Void> deleteById(String id) {
		return dao.deleteById(id);
	}
}
