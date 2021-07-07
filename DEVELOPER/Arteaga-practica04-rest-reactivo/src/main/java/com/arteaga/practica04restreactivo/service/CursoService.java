package com.arteaga.practica04restreactivo.service;

import com.arteaga.practica04restreactivo.model.documents.Curso;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


public interface CursoService {
	public Flux<Curso> findAll();

	public Mono<Curso> findById(String id);

	public Mono<Curso> save(Curso curso);

	public Mono<Void> deleteById(String id);
}
