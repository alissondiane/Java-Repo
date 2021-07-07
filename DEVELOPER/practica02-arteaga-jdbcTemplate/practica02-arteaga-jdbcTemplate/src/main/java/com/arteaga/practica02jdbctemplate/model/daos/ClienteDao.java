package com.arteaga.practica02jdbctemplate.model.daos;

import com.arteaga.practica02jdbctemplate.model.entities.Cliente;

import java.util.List;

public interface ClienteDao {
	Cliente getCliente(Integer id);
	int guardar(Cliente cliente);
	int actualizar(Cliente cliente);
	int eliminar(Integer id);
	List<Cliente> listar();
}
