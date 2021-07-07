package com.arteaga.practica04restreactivo.ws;

import com.arteaga.practica04restreactivo.model.documents.Curso;
import com.arteaga.practica04restreactivo.service.CursoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@CrossOrigin(origins ="http://localhost:4200")
@RestController
@RequestMapping("/api")
public class CursoRestController {

	@Autowired
	private CursoService cursoService;
	
	private static final Logger log = LoggerFactory.getLogger(CursoRestController.class);

	@GetMapping("/cursos")
	public Flux<Curso> index(){

        Flux<Curso> cursos = cursoService.findAll()
        		.map(curso -> {
					curso.setNombre(curso.getNombre().toUpperCase());
        			return curso;
        			})
        		.doOnNext(curso -> log.info(curso.getNombre()));
        
        return cursos;
	}

	@GetMapping("/cursos/{id}")
	public Mono<Curso> show(@PathVariable String id){
		
		//Mono<Curso> curso = cursoService.findById(id);
		
		Flux<Curso> cursos = cursoService.findAll();
		
		Mono<Curso> curso = cursos
				.filter(p -> p.getId().equals(id))
				.next()
				.doOnNext(prod -> log.info(prod.getNombre()));
		return curso;
	}

	@PostMapping("/cursos")
	public Mono<Curso> create(@RequestBody Curso curso){
		Mono<Curso> cursoCreado = cursoService.save(curso);
		return cursoCreado;
	}

	@PutMapping("/cursos/{id}")
	public Mono<Curso> update(@RequestBody Curso curso, @PathVariable String id){

		/*Mono<Curso> cursoObtenido = cursoService.findById(id)
		.map(c -> {
			c.setNombre(curso.getNombre());
			c.setCreditos(curso.getCreditos());
			return curso;
		}).doOnNext(c -> cursoService.save(c));*/
		Mono<Curso> cursoUpdate = cursoService.save(curso);
		return cursoUpdate;
	}

	@DeleteMapping("/cursos/{id}")
	public Mono<Void> delete(@PathVariable String id) {
		System.out.println("Id recibido en el service");
		System.out.println(id);
		Mono<Void> resultado = cursoService.deleteById(id);
		return resultado;
	}
}
