package com.arteaga.practica02jdbctemplate.service;

import com.arteaga.practica02jdbctemplate.model.entities.Cliente;

import java.util.List;

public interface IClienteService {
	
	public List<Cliente> findAll();

	public void save(Cliente cliente);
	
	public Cliente findOne(Long id);
	
	public void delete(Long id);

	public void update(Cliente cliente);
	
}
