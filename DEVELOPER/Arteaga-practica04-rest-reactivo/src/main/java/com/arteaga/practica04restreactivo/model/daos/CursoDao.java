package com.arteaga.practica04restreactivo.model.daos;

import com.arteaga.practica04restreactivo.model.documents.Curso;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CursoDao extends ReactiveMongoRepository<Curso, String> {

}
