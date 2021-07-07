package com.arteaga.practica04rest.model.persistence;

import com.arteaga.practica04rest.model.entity.Curso;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CursoRepository  extends CrudRepository<Curso, String>{

}
