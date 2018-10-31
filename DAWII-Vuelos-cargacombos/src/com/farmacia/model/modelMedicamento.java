package com.farmacia.model;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import com.farmacia.entidad.Medicamento;


public class modelMedicamento {
	EntityManagerFactory fabrica=Persistence.createEntityManagerFactory("PE");
	EntityManager manager=null;
	public void addMedicamento(Medicamento obj){
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
	public void modifyMedicamento(Medicamento obj){
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
	public void deleteMedicamento(int cod){
		manager=fabrica.createEntityManager();
		try {
			manager.getTransaction().begin();
			Medicamento obj=manager.find(Medicamento.class, cod);
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
	public Medicamento findMedicamento(int cod){
		manager=fabrica.createEntityManager();
		Medicamento obj=null;
		try {
			obj=manager.find(Medicamento.class, cod);	
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			manager.close();
			fabrica.close();
		}
		return obj;
	}
	public List<Medicamento> listaMedicamento(){
		EntityManager manager=fabrica.createEntityManager();
		String hql="FROM Medicamento";
		Query q=manager.createQuery(hql, Medicamento.class);
		List<Medicamento> lista=q.getResultList();
		manager.close();
		fabrica.close();
		return lista;
	}
	public List<Medicamento> listaXNombreMedicamento(String nom){
		manager=fabrica.createEntityManager();
		String jpql="from Medicamento m where m.nomMedicamento like CONCAT(:param,'%')";
		List<Medicamento> lista=null;
		try {
			Query q=manager.createQuery(jpql, Medicamento.class);
			q.setParameter("param", nom);
			lista=q.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally{
			manager.close();
			fabrica.close();			
		}
		return lista;
	}
	public List<Medicamento> listaXNombreLaboratorio(String nom){
		manager=fabrica.createEntityManager();
		List<Medicamento> lista=null;
		try {
			String jpql="select m from Medicamento m where m.laboratorio.nomLaboratorio like CONCAT(:param,'%')";
			Query q=manager.createQuery(jpql, Medicamento.class);
			q.setParameter("param", nom);
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
	public int actualizaPrecio(double incremento){
		EntityManager manager=fabrica.createEntityManager();
		String sql = " update Medicamento m set m.precio =m.precio+m.precio*?1";
		manager.getTransaction().begin();
		Query query = manager.createQuery(sql);
		query.setParameter(1, incremento);
		int salida = query.executeUpdate();
		manager.getTransaction().commit();
		return salida;
	}
}
