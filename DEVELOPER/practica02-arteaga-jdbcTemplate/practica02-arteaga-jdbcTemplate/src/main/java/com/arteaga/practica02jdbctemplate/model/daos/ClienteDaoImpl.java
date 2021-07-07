package com.arteaga.practica02jdbctemplate.model.daos;

import com.arteaga.practica02jdbctemplate.model.entities.Cliente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.ParameterizedBeanPropertyRowMapper;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Repository
public class ClienteDaoImpl implements ClienteDao {

	private JdbcTemplate jdbcTemplate;

	@Autowired
	public void setDataSource(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	public Cliente getCliente(Integer id){
		try{
			String sql = "select id, nombre, apellido, email, telefono from clientes where id=?";
			return jdbcTemplate.queryForObject(sql,
					ParameterizedBeanPropertyRowMapper.newInstance(Cliente.class),
					id);
		}catch(EmptyResultDataAccessException e){}
		return null;
	}

	public List<Cliente> listar(){
		List<Map<String, Object>> map = jdbcTemplate.queryForList("select * from clientes");
		List<Object> lista = null;
		List<Cliente> listaClientes = new ArrayList<Cliente>();
		for (Map<String,Object> m: map) {
			lista = new ArrayList(m.values());
			Cliente persona = new Cliente();
			persona.setId(Integer.parseInt(lista.get(0).toString()));
			persona.setNombre(lista.get(1).toString());
			persona.setApellido(lista.get(2).toString());
			persona.setEmail(lista.get(3).toString());
			persona.setTelefono(lista.get(4).toString());
			listaClientes.add(persona);
		};
		return listaClientes;
	}


	public int guardar(Cliente cliente){
		Integer id = this.getUltimoId()+1;
		System.out.println("id obtenido");
		System.out.println(id);
		return jdbcTemplate.update("insert into clientes (id,nombre, apellido,email,telefono) values (?,?, ?, ? ,?)",
				id,cliente.getNombre(), cliente.getApellido(), cliente.getEmail(),cliente.getTelefono());
	}

	public int actualizar(Cliente cliente){
		return jdbcTemplate.update("update clientes set nombre =?, apellido=?, email=? , telefono=? where id=?",
				cliente.getNombre(), cliente.getApellido(), cliente.getEmail(),cliente.getTelefono(), cliente.getId());
	}

	public int eliminar(Integer id){
		return jdbcTemplate.update("delete from clientes where id=?", id);
	}

	public Integer getUltimoId(){
		return jdbcTemplate.queryForObject("select max(id) from clientes", Integer.class);
	}

}
