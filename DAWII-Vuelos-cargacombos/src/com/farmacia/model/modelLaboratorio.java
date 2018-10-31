package com.farmacia.model;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.farmacia.entidad.Laboratorio;
import com.farmacia.entidad.Medicamento;
public class modelLaboratorio {
	EntityManagerFactory fabrica=Persistence.createEntityManagerFactory("PE");
	EntityManager manager=null;
	public void addLaboratorio(Laboratorio obj){
		manager=fabrica.createEntityManager();
		try {
			manager.getTransaction().begin();
			manager.persist(obj);
			manager.flush();
			manager.getTransaction().commit();
		} catch (Exception e) {
			manager.getTransaction().rollback();
			e.printStackTrace();
		}
		finally{
			manager.close();
			fabrica.close();
		}
	}
	public void modifyLaboratorio(Laboratorio obj){
		manager=fabrica.createEntityManager();
		try {
			manager.getTransaction().begin();
			manager.merge(obj);
			manager.flush();
			manager.getTransaction().commit();
		} catch (Exception e) {
			manager.getTransaction().rollback();
			e.printStackTrace();
		}
		finally{
			manager.close();
			fabrica.close();
		}
	}
	public void deleteLaboratorio(int cod){
		manager=fabrica.createEntityManager();
		try {
			manager.getTransaction().begin();
			Laboratorio obj=manager.find(Laboratorio.class, cod);
			manager.remove(obj);
			manager.flush();
			manager.getTransaction().commit();
		} catch (Exception e) {
			manager.getTransaction().rollback();
			e.printStackTrace();
		}
		finally{
			manager.close();
			fabrica.close();
		}
	}
	public Laboratorio findLaboratorio(int cod){
		manager=fabrica.createEntityManager();
		Laboratorio obj=null;
		try {
			obj=manager.find(Laboratorio.class, cod);
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			manager.close();
			fabrica.close();	
		}		
		return obj;
	}
	public List<Laboratorio> listaLaboratorio(){
		manager=fabrica.createEntityManager();
		String hql="FROM Laboratorio";
		List<Laboratorio> lista=null;
		try {
			Query q=manager.createQuery(hql, Laboratorio.class);
			lista=q.getResultList();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			manager.close();
			fabrica.close();			
		}
		return lista;
	}
	
}
