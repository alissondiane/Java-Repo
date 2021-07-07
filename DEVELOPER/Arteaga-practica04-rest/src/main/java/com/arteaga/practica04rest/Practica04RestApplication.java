package com.arteaga.practica04rest;

import com.arteaga.practica04rest.model.entity.Curso;
import com.arteaga.practica04rest.service.CursoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class Practica04RestApplication  implements CommandLineRunner {
    @Autowired
    private CursoService cursoService;


    public static void main(String[] args) {
        SpringApplication.run(Practica04RestApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {


    }
}
