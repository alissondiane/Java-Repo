package com.arteaga.practica01.pruebas;

import com.arteaga.practica01.daos.ClienteService;
import com.arteaga.practica01.pojos.Cliente;

import java.util.List;

public class Prueba01 {
    public static void main(String[] args) {

        System.out.println("***** LISTADO DE CLIENTES *****");
        ClienteService clienteService = new ClienteService();
        //mostrar los registros de clientes
        List<Cliente> clientes = clienteService.getAllClientes();
        for (Cliente cliente : clientes)		  {
            System.out.println(cliente);
        }
    }
}
