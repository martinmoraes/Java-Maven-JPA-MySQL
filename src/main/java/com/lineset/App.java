package com.lineset;

import java.util.ArrayList;
import java.util.List;

import com.lineset.DAO.ProcessoDAO;
import com.lineset.Entity.Parte;
import com.lineset.Entity.Processo;
import com.lineset.tool.Util;

/**
 * Hello world!
 *
 */
public class App {


	public static void main(String[] args) throws InterruptedException {
		
		if (new Util().setUp()) {
			List<Parte> listaPartes = new ArrayList<Parte>();

			Parte parteA = new Parte();
			parteA.setNome("João Joaquim");
			parteA.setPapel("Adevogado");
			listaPartes.add(parteA);
			
			Parte parteB = new Parte();
			parteB.setNome("Zezinho");
			parteB.setPapel("Acusado");
			listaPartes.add(parteB);
			
			Parte parteC = new Parte();
			parteC.setNome("Pedrinho");
			parteC.setPapel("Acusador");
			listaPartes.add(parteC);
			
			Processo processo = new Processo();
			processo.setNumeroProcesso("523958497287502942874094511");
			processo.setDestaque("Adisputa é por uma bola furada");
			processo.setParte(listaPartes);
			
			new ProcessoDAO().salva(processo);
		}

		Util.closeSessionFactory();
	}

}
