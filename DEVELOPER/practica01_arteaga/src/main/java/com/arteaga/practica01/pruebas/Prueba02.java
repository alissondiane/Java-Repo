package com.arteaga.practica01.pruebas;

import com.arteaga.practica01.daos.ClienteService;
import com.arteaga.practica01.pojos.Cliente;

import java.util.List;


public class Prueba02 {

	public static void main(String[] args) {
		ClienteService clienteService = new ClienteService();

		System.out.println("2. Eliminar clientes por código. Usando consultas por código con MyBatis.");

		Cliente clienteDelete = clienteService.getClienteById(11);
		clienteService.deleteCliente(clienteDelete.getIdCliente());

		//mostrar los registros de clientes
		System.out.println("***** LISTADO DE CLIENTES *****");
		List<Cliente> clientes = clienteService.getAllClientes();
		for (Cliente cliente : clientes){
		   System.out.println(cliente);
		}
	}

}
