
package com.arteaga.practica01.hibernate.mapping;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;

@SuppressWarnings("deprecation")
public class HibernateUtil {
	private static final SessionFactory sessionFactory;

	static {
		try {
			sessionFactory = new AnnotationConfiguration().configure("/hibernate.cfg.xml")
					.buildSessionFactory();
		} catch (HibernateException he) {
			System.err
					.println("Ocurrip un error en la inicializacion de la SessionFactory: "
							+ he);
			throw new ExceptionInInitializerError(he);
		}
	}

	public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}

}