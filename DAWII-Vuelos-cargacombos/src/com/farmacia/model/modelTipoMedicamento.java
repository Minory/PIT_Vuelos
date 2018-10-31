package com.farmacia.model;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import com.farmacia.entidad.Modelo;
import com.farmacia.entidad.TipoMedicamento;
public class modelTipoMedicamento {
	private EntityManagerFactory fabrica=Persistence.createEntityManagerFactory("PE");
	EntityManager manager=null;
	public List<TipoMedicamento> listTipoMedicamento(int cod){
		manager=fabrica.createEntityManager();
		String jpql="select tm from TipoMedicamento tm where tm.laboratorio.codLaboratorio=?1";
		Query t=manager.createQuery(jpql,TipoMedicamento.class);
		t.setParameter(1, cod);
		List<TipoMedicamento> lista=t.getResultList();
		manager.close();
		return lista;
	}
	public List<Modelo> listModelo(int codLab,int codTipo){
		manager=fabrica.createEntityManager();
		String jpql="select m from Modelo m where m.laboratorio.codLaboratorio=?1 and m.tipoMedicamento.codTipoMedicamento=?2";
		Query t=manager.createQuery(jpql,Modelo.class);
		t.setParameter(1, codLab);
		t.setParameter(2, codTipo);
		List<Modelo> lista=t.getResultList();
		manager.close();
		return lista;
	}
	
	
}


