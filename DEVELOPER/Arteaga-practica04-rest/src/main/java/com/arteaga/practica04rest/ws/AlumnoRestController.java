package com.arteaga.practica04rest.ws;

import com.arteaga.practica04rest.model.entity.Alumno;
import com.arteaga.practica04rest.service.AlumnoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

@CrossOrigin(origins ="http://localhost:4200")
@RestController
@RequestMapping("/api")
public class AlumnoRestController {
	
	@Autowired
	AlumnoService servicio;
	
	@GetMapping("/alumnos")
	public List<Alumno> index() {
		return servicio.findAll();
	}

	@GetMapping("/alumnos/{id}")
	public Alumno show(@PathVariable String id) {
		return this.servicio.findById(id);
	}

	@PostMapping("/alumnos")
	@ResponseStatus(HttpStatus.CREATED)
	public Alumno create(@RequestBody Alumno alumno) {
		alumno.setFenac(sumarDiasAFecha(alumno.getFenac(),1));
		this.servicio.save(alumno);
		return alumno;
	}

	@PutMapping("/alumnos/{id}")
	@ResponseStatus(HttpStatus.CREATED)
	public Alumno update(@RequestBody Alumno alumno, @PathVariable String id) {
		alumno.setFenac(sumarDiasAFecha(alumno.getFenac(),1));
		Alumno currentAlumno = this.servicio.findById(id);
		currentAlumno.setNombre(alumno.getNombre());
		currentAlumno.setApellido(alumno.getApellido());
		currentAlumno.setFenac(alumno.getFenac());
		currentAlumno.setSexo(alumno.getSexo());
		this.servicio.save(currentAlumno);
		return currentAlumno;
	}

	public static Date sumarDiasAFecha(Date fecha, int dias){
		if (dias==0) return fecha;
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(fecha);
		calendar.add(Calendar.DAY_OF_YEAR, dias);
		return calendar.getTime();
	}

	@DeleteMapping("/alumnos/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable String id) {
		Alumno currentAlumno = this.servicio.findById(id);
		this.servicio.delete(currentAlumno);
	}
	
	
}
