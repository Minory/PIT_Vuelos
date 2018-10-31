package com.farmacia.model;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import com.farmacia.entidad.Aeropuerto;
import com.farmacia.entidad.Ciudad;


public class modelCiudad {
	private EntityManagerFactory fabrica=Persistence.createEntityManagerFactory("PE");
	EntityManager manager=null;
	public List<Ciudad> listCiudad(int cod){
		manager=fabrica.createEntityManager();
		String jpql="select tm from Ciudad tm where tm.pais.codPais=?1";
		Query t=manager.createQuery(jpql,Ciudad.class);
		t.setParameter(1, cod);
		List<Ciudad> lista=t.getResultList();
		manager.close();
		return lista;
	}
	public List<Aeropuerto> listAeropuerto(int codP,int codC){
		manager=fabrica.createEntityManager();
		String jpql="select m from Aeropuerto m where m.pais.codPais=?1 and m.ciudad.codCiudad=?2";
		Query t=manager.createQuery(jpql,Aeropuerto.class);
		t.setParameter(1, codP);
		t.setParameter(2, codC);
		List<Aeropuerto> lista=t.getResultList();
		manager.close();
		return lista;
	}
	
	
}


