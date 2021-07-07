package com.arteaga.practica04rest.model.persistence;

import com.arteaga.practica04rest.model.entity.Alumno;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AlumnoRepository extends CrudRepository<Alumno, String>{

}
