package com.arteaga.practica02.service;

import com.arteaga.practica02.model.entities.Cliente;

import java.util.List;

public interface IClienteService {
	
	public List<Cliente> findAll();

	public void save(Cliente cliente);
	
	public Cliente findOne(Long id);
	
	public void delete(Long id);
	
}
