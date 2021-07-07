package com.arteaga.practica01.daos;


import com.arteaga.practica01.pojos.Cliente;

import java.util.List;

public interface ClienteMapper {

 public void insertCliente(Cliente cliente);
 
 public Cliente getClienteById(Integer clienteId);
 
 public List<Cliente> getAllClientes();
 
 public void updateCliente(Cliente cliente);
 
 public void deleteCliente(Integer clienteId);
 
}

