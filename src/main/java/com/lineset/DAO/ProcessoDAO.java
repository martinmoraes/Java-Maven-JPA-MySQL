package com.lineset.DAO;

import java.util.List;

import javax.persistence.EntityManager;

import com.lineset.Entity.Parte;
import com.lineset.Entity.Processo;
import com.lineset.tool.Util;

public class ProcessoDAO {
	public void salva(Processo processo) {
		try {
			EntityManager entityManager = Util.getSessionFactory().createEntityManager();
			entityManager.getTransaction().begin();
			entityManager.persist(processo);
			List<Parte> listaPartes = processo.getParte();
			if(listaPartes.size() > 0) {
				new PartesDAO().salva(listaPartes);
			}
			entityManager.getTransaction().commit();
			entityManager.close();
		} catch (Exception e) {
			Util.Log("ProcessoDAO - Salva: " + e.toString());
		}
	}

	public void salva(List<Processo> processos) {
		try {
			EntityManager entityManager = Util.getSessionFactory().createEntityManager();
			entityManager.getTransaction().begin();
			processos.forEach(processo -> {
				entityManager.persist(processo);
				List<Parte> listaPartes = processo.getParte();
				if(listaPartes.size() > 0) {
					new PartesDAO().salva(listaPartes);
				}
			});
			entityManager.getTransaction().commit();
			entityManager.close();
		} catch (Exception e) {
			Util.Log("ProcessoDAO - Salva: " + e.toString());
		}
	}
}
