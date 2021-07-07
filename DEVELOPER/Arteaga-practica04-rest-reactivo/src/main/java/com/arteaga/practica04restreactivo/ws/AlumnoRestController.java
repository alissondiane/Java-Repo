package com.arteaga.practica04restreactivo.ws;

import com.arteaga.practica04restreactivo.model.documents.Alumno;
import com.arteaga.practica04restreactivo.model.documents.Curso;
import com.arteaga.practica04restreactivo.service.AlumnoService;
import com.arteaga.practica04restreactivo.service.CursoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Calendar;
import java.util.Date;

@CrossOrigin(origins ="http://localhost:4200")
@RestController
@RequestMapping("/api")
public class AlumnoRestController {
    @Autowired
    private AlumnoService alumnoService;

    private static final Logger log = LoggerFactory.getLogger(AlumnoRestController.class);

    @GetMapping("/alumnos")
    public Flux<Alumno> index(){

        Flux<Alumno> cursos = alumnoService.findAll()
                .map(curso -> {
                    curso.setNombre(curso.getNombre().toUpperCase());
                    return curso;
                })
                .doOnNext(curso -> log.info(curso.getNombre()));

        return cursos;
    }

    @GetMapping("/alumnos/{id}")
    public Mono<Alumno> show(@PathVariable String id){

        //Mono<Curso> curso = cursoService.findById(id);

        Flux<Alumno> alumnos = alumnoService.findAll();

        Mono<Alumno> alumno = alumnos
                .filter(p -> p.getId().equals(id))
                .next()
                .doOnNext(alum -> log.info(alum.getNombre()));
        return alumno;
    }

    @PostMapping("/alumnos")
    public Mono<Alumno> create(@RequestBody Alumno alumno){
        alumno.setFenac(sumarDiasAFecha(alumno.getFenac(),1));
        Mono<Alumno> alumnoCreado = alumnoService.save(alumno);
        return alumnoCreado;
    }

    @PutMapping("/alumnos/{id}")
    public Mono<Alumno> update(@RequestBody Alumno alumno, @PathVariable String id){

		/*Mono<Curso> cursoObtenido = cursoService.findById(id)
		.map(c -> {
			c.setNombre(curso.getNombre());
			c.setCreditos(curso.getCreditos());
			return curso;
		}).doOnNext(c -> cursoService.save(c));*/
        alumno.setFenac(sumarDiasAFecha(alumno.getFenac(),1));
        Mono<Alumno> alumnoUpdate = alumnoService.save(alumno);
        return alumnoUpdate;
    }

    public static Date sumarDiasAFecha(Date fecha, int dias){
        if (dias==0) return fecha;
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(fecha);
        calendar.add(Calendar.DAY_OF_YEAR, dias);
        return calendar.getTime();
    }

    @DeleteMapping("/alumnos/{id}")
    public Mono<Void> delete(@PathVariable String id) {
        System.out.println("Id recibido en el service");
        System.out.println(id);
        Mono<Void> resultado = alumnoService.deleteById(id);
        return resultado;
    }
}
