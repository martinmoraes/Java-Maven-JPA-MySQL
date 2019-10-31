package com.lineset.tool;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Util {

	public static EntityManagerFactory sessionFactory;

	public static EntityManagerFactory getSessionFactory() {
		return sessionFactory;
	}
	
	public static void closeSessionFactory() {
		sessionFactory.close();
	}


	

	public boolean setUp() {
		sessionFactory = Persistence.createEntityManagerFactory("br.com.lineset.JPA");

		return true;
	}
	
	public static void Log(String str) {
		System.out.println("Log: "+ str);
	}
}
