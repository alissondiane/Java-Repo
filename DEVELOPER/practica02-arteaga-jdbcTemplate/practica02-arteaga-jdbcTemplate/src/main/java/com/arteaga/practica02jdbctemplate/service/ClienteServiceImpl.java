package com.arteaga.practica02jdbctemplate.service;

import com.arteaga.practica02jdbctemplate.model.daos.ClienteDao;
import com.arteaga.practica02jdbctemplate.model.daos.JdbcTemplateDao;
import com.arteaga.practica02jdbctemplate.model.entities.Cliente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ClienteServiceImpl implements IClienteService {

	@Autowired
	ClienteDao clienteDao;

	/*
	@Autowired
	private JdbcTemplateDao jdbcTemplateDao;
	*/
	@Override
	public List<Cliente> findAll() {
		// TODO Auto-generated method stub
		return (List<Cliente>) clienteDao.listar();
	}

	@Override
	public void save(Cliente cliente) {
		clienteDao.guardar(cliente);
	}

	@Override
	public Cliente findOne(Long id) {
		// TODO Auto-generated method stub
		return clienteDao.getCliente(id.intValue());
	}

	@Override
	public void delete(Long id) {
		clienteDao.eliminar(id.intValue());
		
	}

	@Override
	public void update(Cliente cliente) {
		clienteDao.actualizar(cliente);
	}
}
