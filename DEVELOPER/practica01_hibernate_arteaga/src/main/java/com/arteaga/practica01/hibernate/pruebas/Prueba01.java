package com.arteaga.practica01.hibernate.pruebas;

import com.arteaga.practica01.hibernate.domain.Cliente;
import com.arteaga.practica01.hibernate.mapping.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.Iterator;
import java.util.List;

public class Prueba01 {
	public static void main(String[] args) {

		SessionFactory factory = HibernateUtil.getSessionFactory();
		Session session = factory.openSession();

		System.out.println("1. Consulta de todos los clientes, use lista de clientes mediante HQL.");
		System.out.println("**********************************************************************");
		//hql
		String sql = "from Cliente c";
		List<Cliente> listaClientes = session.createQuery(sql).list();
		displayClientesList(listaClientes);
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
