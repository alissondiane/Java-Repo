package com.arteaga.practica02.model.daos;


import com.arteaga.practica02.model.entities.Cliente;
import org.springframework.data.repository.CrudRepository;

public interface IClienteDao extends CrudRepository<Cliente, Long>{


}
