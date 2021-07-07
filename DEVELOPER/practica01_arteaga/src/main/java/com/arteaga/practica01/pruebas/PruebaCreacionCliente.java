package com.arteaga.practica01.pruebas;

import com.arteaga.practica01.daos.ClienteService;
import com.arteaga.practica01.pojos.Cliente;

import java.util.List;

public class PruebaCreacionCliente {
    public static void main(String[] args) {
        ClienteService clienteService = new ClienteService();

        System.out.println("Creacion de un cliente");

        //nuevo cliente
        Cliente clienteNuevo = new Cliente();
        clienteNuevo.setApellidos("Carranza");
        clienteNuevo.setNombres("Rosamaria");
        clienteNuevo.setCorreo("rosaliaramirez@gmail.com");
        clienteNuevo.setTelefono("956-234-245");
        clienteService.insertCliente(clienteNuevo);

        System.out.println("LISTADO DE CLIENTES");
        System.out.println("-------------------------------------------");
        List<Cliente> clientes = clienteService.getAllClientes();
        for (Cliente cliente : clientes){
            System.out.println(cliente);
        }
    }
}
