package com.arteaga.practica01.hibernate.pruebas;

import com.arteaga.practica01.hibernate.domain.Cliente;
import com.arteaga.practica01.hibernate.mapping.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class PruebaCreacionCliente {

	public static void main(String[] args) {
		SessionFactory factory = null;
		Session session = null;
		try {

			factory = HibernateUtil.getSessionFactory();
			session = factory.openSession();

			Cliente cliente = new Cliente();
			cliente.setNombres("Rosalia");
			cliente.setApellidos("Rengifo");
			cliente.setCorreo("rosalia@gmail.com");
			cliente.setTelefono("234-342-644");

			session.getTransaction().begin();
			session.save(cliente);
			session.getTransaction().commit();
			System.out.println("Todo ok.");

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				session.close();
			} catch (Exception e) {
			}
			try {
				factory.close();
			} catch (Exception e) {
			}
		}
	}

}
