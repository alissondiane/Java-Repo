package com.arteaga.practica01.hibernate.pruebas;

import com.arteaga.practica01.hibernate.domain.Cliente;
import com.arteaga.practica01.hibernate.mapping.HibernateUtil;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.Iterator;
import java.util.List;

public class Prueba04 {
    public static void main(String[] args) {
        SessionFactory factory = HibernateUtil.getSessionFactory();
        Session session = factory.openSession();

        // Perform HQL Query with named query
        System.out.println("\n---Performing HQL query with named query...");
        Query query = session.getNamedQuery("GET_CLIENTES_BY_ID_OR_NOMBRES_OR_APELLIDOS");


        System.out.print("4. Buscar Clientes por: código, nombre o apellido. Usando Named Queries\n");
        System.out.println("**********************************************************************");

        System.out.println("a. Por id Cliente : " + 1);
        Cliente cliente1 = new Cliente();
        cliente1.setIdCliente(1);
        query.setParameter("idcliente",cliente1.getIdCliente());
        query.setParameter("nombres",cliente1.getNombres());
        query.setParameter("apellidos",cliente1.getApellidos());

        List<Cliente> resultadoClientes = query.list();

        displayClientesList(resultadoClientes);
        System.out.println();

        System.out.println("b. Por Nombres : " + "Ana");

        Cliente cliente2 = new Cliente();
        cliente2.setNombres("Ana");
        query.setParameter("idcliente",cliente2.getIdCliente());
        query.setParameter("nombres",cliente2.getNombres());
        query.setParameter("apellidos",cliente2.getApellidos());

        resultadoClientes = query.list();
        displayClientesList(resultadoClientes);
        System.out.println();

        System.out.println("c. Por Apellidos : " + "Raymondi");

        Cliente cliente3 = new Cliente();
        cliente3.setApellidos("Raymondi");
        query.setParameter("idcliente",cliente3.getIdCliente());
        query.setParameter("nombres",cliente3.getNombres());
        query.setParameter("apellidos",cliente3.getApellidos());

        resultadoClientes = query.list();
        displayClientesList(resultadoClientes);
        System.out.println();

        System.out.println("d. Por Nombres y Apellidos : " + "Luis Raymondi");

        Cliente cliente4 = new Cliente();
        cliente4.setApellidos("Raymondi");
        cliente4.setNombres("Luis");
        query.setParameter("idcliente",cliente4.getIdCliente());
        query.setParameter("nombres",cliente4.getNombres());
        query.setParameter("apellidos",cliente4.getApellidos());

        resultadoClientes = query.list();
        displayClientesList(resultadoClientes);

        session.close();
        factory.close();
    }

    public static void displayClientesList(List list){

        Iterator iter = list.iterator();
        if (!iter.hasNext()){
            System.out.println("No se encontraron clientes con los criterios de busqueda seleccionados");
            return;
        }
        System.out.println("-------------------------------------------------");

        System.out.println("ID \t NOMBRES \t APELLIDOS \t CORREO \t TELEFONO");
        System.out.println("-------------------------------------------------");

        while (iter.hasNext()){
            Cliente cliente = (Cliente) iter.next();
            String msg = cliente.getIdCliente() + "\t";
            msg += cliente.getNombres() + "\t";
            msg += cliente.getApellidos() + "\t";
            msg += cliente.getCorreo() + "\t";
            msg += cliente.getTelefono();
            System.out.println(msg);
        }
    }
}
