package com.arteaga.practica04restreactivo.model.daos;

import com.arteaga.practica04restreactivo.model.documents.Alumno;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AlumnoDao extends ReactiveMongoRepository<Alumno, String> {

}
