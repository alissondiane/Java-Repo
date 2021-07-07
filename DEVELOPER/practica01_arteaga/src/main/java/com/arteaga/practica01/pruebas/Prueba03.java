package com.arteaga.practica01.pruebas;

import com.arteaga.practica01.daos.ClienteService;
import com.arteaga.practica01.pojos.Cliente;
import jdk.swing.interop.SwingInterOpUtils;

import java.util.List;

public class Prueba03 {
    public static void main(String[] args) {
        ClienteService clienteService = new ClienteService();

        System.out.println("3. Actualizar los datos de un registro de la tabla clientes mediante MyBatis");

        //mostrar los registros de clientes
        List<Cliente> clientes = clienteService.getAllClientes();
        System.out.println("LISTADO DE CLIENTES ANTES DE ACTUALIZACION");
        System.out.println("-------------------------------------------");
        for (Cliente cliente : clientes){
            System.out.println(cliente);
        }
        //actualizando
        Cliente cliente2 = clienteService.getClienteById(8);
        cliente2.setNombres(cliente2.getNombres()+" Actualizado");
        cliente2.setApellidos(cliente2.getApellidos()+" Actualizado");
        clienteService.updateCliente(cliente2);

        //mostrar los registros de clientes actualizados
        System.out.println("LISTADO DE CLIENTES CON CLIENTE ACTUALIZADO");
        System.out.println("-------------------------------------------");
        clientes = clienteService.getAllClientes();
        for (Cliente cliente : clientes){
            System.out.println(cliente);
        }
    }
}
