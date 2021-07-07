package com.arteaga.practica04restreactivo.service;

import com.arteaga.practica04restreactivo.model.documents.Alumno;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

public interface AlumnoService {
	public Flux<Alumno> findAll();

	public Mono<Alumno> findById(String id);

	public Mono<Alumno> save(Alumno alumno);

	public Mono<Void> deleteById(String id);
}
