package com.farmacia.model;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import com.farmacia.entidad.Distrito;
public class modelDistrito {
	EntityManagerFactory fabrica=Persistence.createEntityManagerFactory("PE");
	EntityManager manager=null;
	public Distrito buscar(int cod){
		manager=fabrica.createEntityManager();
		Distrito distrito=null;
		try {
			distrito=manager.find(Distrito.class, cod);
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally{
			manager.close();
			fabrica.close();
		}
		return distrito;
	}
	public void eliminar(int cod){
		manager=fabrica.createEntityManager();
		try {
			Distrito x= manager.find(Distrito.class, cod);
			manager.getTransaction().begin();
			manager.remove(x);
			manager.flush();
			manager.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally{
			manager.close();
			fabrica.close();
		}
	}
	public Distrito findDistrito(int cod){
		manager=fabrica.createEntityManager();
		Distrito distrito=null;
		try {
			distrito=manager.find(Distrito.class, cod);
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally{
			manager.close();
			fabrica.close();
		}
		return distrito;
	}
}
