package com.farmacia.model;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import com.farmacia.entidad.Tipo_Avion;




public class modelTipoAvion {
	private EntityManagerFactory fabrica=Persistence.createEntityManagerFactory("PE");
	EntityManager manager=null;
	public List<Tipo_Avion> listTipoAvion(int cod){
		manager=fabrica.createEntityManager();
		String jpql="select tm from Tipo_Avion tm where tm.aerolinea.codAerolinea=?1";
		Query t=manager.createQuery(jpql,Tipo_Avion.class);
		t.setParameter(1, cod);
		List<Tipo_Avion> lista=t.getResultList();
		manager.close();
		return lista;
	}
	
	
	
}


