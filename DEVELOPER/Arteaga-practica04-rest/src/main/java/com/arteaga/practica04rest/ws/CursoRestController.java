package com.arteaga.practica04rest.ws;

import com.arteaga.practica04rest.model.entity.Curso;
import com.arteaga.practica04rest.service.CursoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins ="http://localhost:4200")
@RestController
@RequestMapping("/api")
public class CursoRestController {
	
	@Autowired
	CursoService servicio;
	
	@GetMapping("/cursos")
	public List<Curso> index() {
		return servicio.findAll();
	}

	@GetMapping("/cursos/{id}")
	public Curso show(@PathVariable String id) {
		return this.servicio.findById(id);
	}

	@PostMapping("/cursos")
	@ResponseStatus(HttpStatus.CREATED)
	public Curso create(@RequestBody Curso curso) {
		this.servicio.save(curso);
		return curso;
	}

	@PutMapping("/cursos/{id}")
	@ResponseStatus(HttpStatus.CREATED)
	public Curso update(@RequestBody Curso curso, @PathVariable String id) {
		Curso currentCliente = this.servicio.findById(id);
		currentCliente.setNombre(curso.getNombre());
		currentCliente.setCreditos(curso.getCreditos());
		this.servicio.save(currentCliente);
		return currentCliente;
	}

	@DeleteMapping("/cursos/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable String id) {
		Curso currentCliente = this.servicio.findById(id);
		this.servicio.delete(currentCliente);
	}
	
	
}
