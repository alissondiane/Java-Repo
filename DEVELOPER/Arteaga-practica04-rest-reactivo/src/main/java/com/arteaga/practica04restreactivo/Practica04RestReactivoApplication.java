package com.arteaga.practica04restreactivo;

import com.arteaga.practica04restreactivo.model.documents.Curso;
import com.arteaga.practica04restreactivo.service.CursoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.core.ReactiveMongoTemplate;
import reactor.core.publisher.Flux;

import java.util.Date;

@SpringBootApplication
public class Practica04RestReactivoApplication implements CommandLineRunner {

    @Autowired
    private CursoService cursoService;

    @Autowired
    private ReactiveMongoTemplate mongoTemplate;

    private static final Logger log = LoggerFactory.getLogger(Practica04RestReactivoApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(Practica04RestReactivoApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        /*
        mongoTemplate.dropCollection("cursos").subscribe();

        Flux.just(new Curso("c01","Java Expert",6),
                new Curso("c02","Java Developer",4)
        )
                .flatMap(curso -> {
                    return cursoService.save(curso);
                })
                .subscribe(curso -> log.info("Insert: " + curso.getId() + " " + curso.getNombre()));


         */

    }
}
