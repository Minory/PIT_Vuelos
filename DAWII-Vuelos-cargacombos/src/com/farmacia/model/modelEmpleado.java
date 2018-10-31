package com.farmacia.model;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.farmacia.entidad.Empleado;


public class modelEmpleado {
	EntityManagerFactory fabrica=Persistence.createEntityManagerFactory("PE");
	EntityManager manager=null;
	public void registra(Empleado e){
		manager=fabrica.createEntityManager();
		try {
			manager.getTransaction().begin();
			manager.persist(e);
			manager.flush();
			manager.getTransaction().commit();
		} catch (Exception ex) {
			manager.getTransaction().rollback();
			ex.printStackTrace();
		}
		finally{
			manager.close();
			fabrica.close();
		}
		
	}
}
