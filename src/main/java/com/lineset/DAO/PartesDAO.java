package com.lineset.DAO;

import java.util.List;

import javax.persistence.EntityManager;

import com.lineset.Entity.Parte;
import com.lineset.tool.Util;



public class PartesDAO {
	
	public void salva(Parte partes) {
		try {
			EntityManager entityManager = Util.getSessionFactory().createEntityManager();
			entityManager.getTransaction().begin();
			entityManager.persist(partes);
			entityManager.getTransaction().commit();
			entityManager.close();
		} catch (Exception e) {
			Util.Log("PartesDAO - Salva: " + e.toString());
		}
	}

	public void salva(List<Parte> partes) {
		try {
			EntityManager entityManager = Util.getSessionFactory().createEntityManager();
			entityManager.getTransaction().begin();
			partes.forEach(action -> entityManager.persist(action));
			entityManager.getTransaction().commit();
			entityManager.close();
		} catch (Exception e) {
			Util.Log("PartesDAO - Salva List: " + e.toString());
		}
	}

	public List<Parte> lista() {
		try {
			EntityManager entityManager = Util.getSessionFactory().createEntityManager();
			entityManager.getTransaction().begin();
			List<Parte> result = entityManager.createQuery("from parte", Parte.class).getResultList();
			entityManager.getTransaction().commit();
			entityManager.close();
			return result;
		} catch (Exception e) {
			Util.Log("ArquivoDao - Salva: " + e.toString());
			return null;
		}
	}

}
