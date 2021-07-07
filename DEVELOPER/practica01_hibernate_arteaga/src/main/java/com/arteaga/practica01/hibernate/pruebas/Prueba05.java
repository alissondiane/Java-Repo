package com.arteaga.practica01.hibernate.pruebas;

import com.arteaga.practica01.hibernate.domain.Cliente;
import com.arteaga.practica01.hibernate.mapping.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;

public class Prueba05 {
    public static void main(String[] args) {
        SessionFactory factory = HibernateUtil.getSessionFactory();
        Session session = factory.openSession();

        List<Cliente> lista = session.createCriteria(Cliente.class).list();

        System.out.println("5. Desarrollo los mapeos necesarios para hacer una consulta usando Criteria Query.");
        System.out.println("**********************************************************************************");
        for (Cliente c : lista) {
            System.out.println("---------------------------------");
            System.out.println("ID: " + c.getIdCliente());
            System.out.println("NOMBRE: " + c.getNombres());
            System.out.println("APELLIDOS: " + c.getApellidos());
            System.out.println("CORREO: " + c.getCorreo());
            System.out.println("TELEFONO: " + c.getTelefono());
        }
        session.close();
        factory.close();
    }
}
